package hsbc.hkth.bo;

import hsbc.hkth.api.service.RtvPymntHistoryService;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.google.gson.JsonArray;

public class PaymentsBO {

	public JsonArray getPaymentsForAccount() {

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
		
		return payments;
	}
}
