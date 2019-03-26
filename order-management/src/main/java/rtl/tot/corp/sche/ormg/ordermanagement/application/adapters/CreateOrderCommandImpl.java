package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;

import javax.validation.constraints.NotNull;
import lombok.Data;
import rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Folios;
import rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Reserve;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.ports.CreateOrderCommand;
import rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain.CustomerOrder;
import rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain.Dispatch;
import rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain.Sku;

@Data
public class CreateOrderCommandImpl implements CreateOrderCommand<CustomerOrder> {

	@NotNull
	Integer orderType;
	@NotNull
	String orderId;
	@NotNull
	Folios folios = new Folios();
	@NotNull
	Reserve reserve = new Reserve();

	public CreateOrderCommandImpl(CustomerOrder request) {
		
		this.setOrderId(request.getOrderId());
		this.setOrderType(request.getOrderType());
		
		if (request.getReserve() != null) {
			for (rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain.Reserve.Dispatch dispatch : request
					.getReserve().getDispatch()) {
				rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Reserve.Dispatch newDispatch = new rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Reserve
						.Dispatch();
				newDispatch.setDateDispatch(dispatch.getDateDispatch());
				newDispatch.setStore(dispatch.getStore());
				for(Sku sku:dispatch.getSku()) {
					rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Sku newSku = new rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Sku();
					newSku.setQuantity(sku.getQuantity());
					newSku.setSku(sku.getSku());
					
					newDispatch.getSku().add(newSku);
				}
				this.reserve.getDispatch().add(newDispatch);
			}
		}
		if (request.getFolios() != null) {
			this.folios.setFolioComuna(request.getFolios().getFolioComuna());
			this.folios.setObservation(request.getFolios().getObservation());
			
			if (request.getFolios().getPurchaser() != null) {
				this.folios.getPurchaser().setCustomerAddress(request.getFolios().getPurchaser().getCustomerAddress());
				this.folios.getPurchaser()
						.setCustomerDocumentNumber(request.getFolios().getPurchaser().getCustomerDocumentNumber());
				this.folios.getPurchaser()
						.setCustomerDocumentType(request.getFolios().getPurchaser().getCustomerDocumentType());
				this.folios.getPurchaser()
						.setCustomerLastName(request.getFolios().getPurchaser().getCustomerLastName());
				this.folios.getPurchaser().setCustomerName(request.getFolios().getPurchaser().getCustomerName());
				this.folios.getPurchaser().setCustomerPhone(request.getFolios().getPurchaser().getCustomerPhone());
			}
			if (request.getFolios().getReceiver() != null) {

				this.folios.getReceiver().setReceiverAddress(request.getFolios().getReceiver().getReceiverAddress());
				this.folios.getReceiver().setReceiverAddressLocationType(
						request.getFolios().getReceiver().getReceiverAddressLocationType());
				this.folios.getReceiver()
						.setReceiverDocumentNumber(request.getFolios().getReceiver().getReceiverDocumentNumber());
				this.folios.getReceiver()
						.setReceiverDocumentType(request.getFolios().getReceiver().getReceiverDocumentType());
				this.folios.getReceiver().setReceiverEmail(request.getFolios().getReceiver().getReceiverEmail());
				this.folios.getReceiver().setReceiverFloor(request.getFolios().getReceiver().getReceiverFloor());
				this.folios.getReceiver().setReceiverLastName(request.getFolios().getReceiver().getReceiverLastName());
				this.folios.getReceiver().setReceiverMobile(request.getFolios().getReceiver().getReceiverMobile());
				this.folios.getReceiver().setReceiverName(request.getFolios().getReceiver().getReceiverName());
				this.folios.getReceiver().setReceiverPhone(request.getFolios().getReceiver().getReceiverPhone());
				this.folios.getReceiver()
						.setReceiverPostalCode(request.getFolios().getReceiver().getReceiverPostalCode());
				this.folios.getReceiver()
						.setReceiverSecondLastName(request.getFolios().getReceiver().getReceiverSecondLastName());
			}

			for (Dispatch dispatch : request.getFolios().getDispatch()) {
				rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Dispatch newDispatch = new rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Dispatch();
				newDispatch.setDeliveryWh(dispatch.getDeliveryWh());
				newDispatch.setDispatchWh(dispatch.getDispatchWh());
				newDispatch.setFolioDateDispatch(dispatch.getFolioDateDispatch());
				newDispatch.setFolioHourDispatch(dispatch.getFolioHourDispatch());
				newDispatch.setFolioPriceDispatch(dispatch.getFolioPriceDispatch());
				newDispatch.setFolioSkuDispatch(dispatch.getFolioSkuDispatch());
				newDispatch.setRutProvider(dispatch.getRutProvider());
				newDispatch.setSalesStore(dispatch.getSalesStore());
				for (Sku sku : dispatch.getSku()) {
					rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Sku newSku = new rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Sku();
					newSku.setQuantity(sku.getQuantity());
					newSku.setSku(sku.getSku());

					newDispatch.getSku().add(newSku);

				}
				this.folios.getDispatch().add(newDispatch);
			}

		}

	}
}