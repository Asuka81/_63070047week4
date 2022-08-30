package com.example._63070047week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    public CashierView() {
        TextField cash = new TextField();
        cash.setLabel("เงินทอน");
        cash.setPlaceholder("$");

        Button btn = new Button("คำนวณเงินทอน");

        TextField n1000 = new TextField();
        n1000.setPlaceholder("$1000:");
        TextField n500 = new TextField();
        n500.setPlaceholder("$500:");
        TextField n100 = new TextField();
        n100.setPlaceholder("$100:");
        TextField n20 = new TextField();
        n20.setPlaceholder("$20:");
        TextField n10 = new TextField();
        n10.setPlaceholder("$10:");
        TextField n5 = new TextField();
        n5.setPlaceholder("$5:");
        TextField n1 = new TextField();
        n1.setPlaceholder("$1:");

        add(cash, btn, n1000, n500, n100, n20, n10, n5, n1);

        btn.addClickListener(event ->{
            int num = Integer.parseInt(cash.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+num)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            n1000.setValue("$1000: "+out.getB1000()+"");
            n500.setValue("$500: "+out.getB500()+"");
            n100.setValue("$100: "+out.getB100()+"");
            n20.setValue("$20: "+out.getB20()+"");
            n10.setValue("$10: "+out.getB10()+"");
            n5.setValue("$5: "+out.getB5()+"");
            n1.setValue("$1: "+out.getB1()+"");
        });
    }
}
