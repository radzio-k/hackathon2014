package hsbc.hkth.bo;

import hsbc.hkth.api.service.RtvPymntHistoryService;
import hsbc.hkth.api.service.internal.CalculateTxFXOptimisationSumService;
import hsbc.hkth.api.service.internal.CalculateTxFeeOptimisationSumService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class PaymentsBO {

	public JsonObject getPaymentsForAccount() {

		Random random = new Random(System.nanoTime());
		RtvPymntHistoryService service = new RtvPymntHistoryService();
		JsonArray paymentHistory = service.retrievePaymentHistory();

		JsonArray payments = new JsonArray();
		Set<Integer> selectedPayments = new HashSet<>();

		int paymentsNumber = 4 + random.nextInt(3);
		for (int i = 0; i < paymentsNumber; i++) {
			int index = 0;
			do {
				index = random.nextInt(paymentHistory.size());
			} while (selectedPayments.contains(index));

			selectedPayments.add(index);
			payments.add(paymentHistory.get(index));

		}
		
		CalculateTxFeeOptimisationSumService calculateTxFeeOptimisationSumService = new CalculateTxFeeOptimisationSumService();
		BigDecimal txFeeOptimisationSum = calculateTxFeeOptimisationSumService.calculateGBPtoEURTxFeeOptimSumFromJSonArray(payments);
		
		CalculateTxFXOptimisationSumService calculateTxFXOptimisationSumService = new CalculateTxFXOptimisationSumService();
		BigDecimal txFxOptimisationSUm = calculateTxFXOptimisationSumService.calculateGBPtoEURTxFXOptimSumFromJSonArray(payments);
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("payments", payments);
		jsonObject.add("txFeeOptimisationSum", new JsonPrimitive(txFeeOptimisationSum));
		jsonObject.add("txFxOptimisationSUm", new JsonPrimitive(txFxOptimisationSUm));
		
		return jsonObject;
	}
}
