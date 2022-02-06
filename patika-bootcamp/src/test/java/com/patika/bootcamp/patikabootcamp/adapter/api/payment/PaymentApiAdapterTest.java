package com.patika.bootcamp.patikabootcamp.adapter.api.payment;

import com.patika.bootcamp.patikabootcamp.BaseIntegrationTest;
import com.patika.bootcamp.patikabootcamp.domain.account.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL, //StubsMode.REMOTE nexus ?
        ids = "patika.payment:payment-api:+:stubs:8090") //produce edilen stub'ın group ve artifact id'si + stub'ların run edileceği port
class PaymentApiAdapterTest extends BaseIntegrationTest {

    @Autowired
    PaymentApiAdapter paymentApiAdapter;

    @Test
    void should_validate_payment() {
        //given
        Account account = Account.builder().mail("mustafa@patika.com").build();

        //when
        boolean result = paymentApiAdapter.validatePayment(account);

        //then
        assertThat(result).isTrue();
    }

}