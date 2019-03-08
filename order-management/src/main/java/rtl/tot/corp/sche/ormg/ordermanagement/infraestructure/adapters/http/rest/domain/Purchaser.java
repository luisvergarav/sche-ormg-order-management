package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class Purchaser {
	@Null 
	String customerAddress;
    @NotNull
	String customerDocumentNumber;
    @NotNull
    String customerDocumentType;
    @NotNull
    String customerLastName;
    @NotNull
    String customerName;
    @Null
    String customerPhone;
}
