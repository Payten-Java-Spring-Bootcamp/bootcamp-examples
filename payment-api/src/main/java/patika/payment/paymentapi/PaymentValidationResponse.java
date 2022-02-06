package patika.payment.paymentapi;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentValidationResponse {

    private String mail;
    private PaymentState paymentState;
}
