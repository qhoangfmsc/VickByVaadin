package com.athenaweb.ui.components.consultant;

import com.athenaweb.backend.entity.Consultant;
import com.athenaweb.backend.service.ConsultantService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;
import java.util.function.Consumer;

public class ConsultantList extends Composite<VerticalLayout> {
    private final ConsultantService consultantService;

    public ConsultantList(ConsultantService consultantService) {
        this.consultantService = consultantService;
        System.out.println("ConsultantList running...");

//        getDataConsultant().thenAccept(this::updateUIConsultant);
        getDataConsultantWithCallback(this::updateUIConsultantWithCallback);
    }

//    private void updateUIConsultant(List<Consultant> consultantList) {
//        System.out.println("ConsultantList updateUIConsultant running... " + getUI() + " and " + UI.getCurrent());
//        getUI().ifPresent(ui -> ui.access(() -> {
//            System.out.println("ConsultantList updateUIConsultant access running... " + ui);
//            if (consultantList != null && !consultantList.isEmpty()) {
//                consultantList.forEach(consultantData -> {
//                    ConsultantItem item = new ConsultantItem(
//                            consultantData.getAvatarlink(),
//                            consultantData.getDisplayname(),
//                            consultantData.getDescription(),
//                            consultantData.getInvestmentstyle(),
//                            consultantData.getInvestmentphilosophy(),
//                            consultantData.getRating()
//                    );
//                    getContent().add(item);
//                });
//            } else {
//                System.out.println("Consultant list empty");
//            }
//        }));
//    }
//
//
//    private CompletableFuture<List<Consultant>> getDataConsultant() {
//        System.out.println("ConsultantList getDataConsultant running...");
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                return consultantService.findDataList();
//            } catch (Exception e) {
//                System.out.println(e.toString());
//                return Collections.emptyList();
//            }
//        });
//    }

    private void getDataConsultantWithCallback(Consumer<List<Consultant>> callback) {
        List<Consultant> consultantList =consultantService.findDataList();
        callback.accept(consultantList);
    }

    private void updateUIConsultantWithCallback(List<Consultant> consultantList) {
        consultantList.forEach(consultantData -> {
            ConsultantItem item = new ConsultantItem(
                    consultantData.getAvatarlink(),
                    consultantData.getDisplayname(),
                    consultantData.getDescription(),
                    consultantData.getInvestmentstyle(),
                    consultantData.getInvestmentphilosophy(),
                    consultantData.getRating()
            );
            getContent().add(item);
        });
    }
}
