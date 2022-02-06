package patika.payment.paymentapi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/payment-validations")
    public PaymentValidationResponse validateResponse(@RequestParam String mail) {
        log.info("Payment validation requested for: {}", mail);
        return PaymentValidationResponse.builder()
                .mail(mail)
                .paymentState(PaymentState.APPROVED)
                .build();
    }
}
