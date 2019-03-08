package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class Receiver {
	@NotNull 
	String receiverAddress;
    @NotNull
	String receiverAddressLocationType;
    @Null
    String receiverPostalCode;
    @NotNull
    Integer receiverFloor;
    @NotNull
    String receiverDocumentType;
    @NotNull
    String receiverDocumentNumber;
    @NotNull
    String receiverLastName;
    @Null
    String receiverSecondLastName;
    @NotNull
    String receiverName;
    @Null
    String receiverPhone;
    @NotNull
    String receiverMobile;
    @NotNull
    String receiverEmail;
    }
