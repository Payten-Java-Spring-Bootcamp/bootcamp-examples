package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should validate payment"

    request {
        url "/payment-validations?mail=mustafa@patika.com"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                "mail": "mustafa@patika.com",
                "paymentState": "APPROVED"
        )
    }
}
