package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.OrderCreatedIntegrationEvent;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.OrderLine;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.Sku;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.StorePC;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.StorePreOrder;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.WarehousePC;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.WarehousePreOrder;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.EventType;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.ports.CommandBus;
import rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.http.rest.domain.Dispatch;
import rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.output.asb.EventPublisherService;

@Slf4j
public class DecoratorCreateOrderCommandBus implements CommandBus<CreateOrderCommandImpl> {

	@Autowired
	EventPublisherService publisher;
	CreateOrderCommandBus bus;

	public DecoratorCreateOrderCommandBus(CreateOrderCommandBus bus) {
		this.bus = bus;
	}

	@Override
	public boolean execute(CreateOrderCommandImpl command) throws Exception {

	        OrderCreatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new OrderCreatedIntegrationEvent();
    	        integrationEvent.setStatus("orderCreated");
    	        if (command.getReserve() != null) {
    				integrationEvent.setOrderId(command.getReserve().getOrderId());
    				OrderLine orderLine = new OrderLine();
        			
    				StorePC spc = new StorePC();
					spc.setOrderId(command.getReserve().getOrderId());
					orderLine.setPc(spc);
					
    				for (rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Reserve.Dispatch dispatch : command
    						.getReserve().getDispatch()) {
    					
    			
    					
    					StorePreOrder storePreOrder = new StorePreOrder();
    					
    					storePreOrder.setDateDispatch(dispatch.getDateDispatch());
    					storePreOrder.setStore(dispatch.getStore());
    					
    					for(rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Sku sku:dispatch.getSku()) {
    					
    						Sku newSku = new Sku();
    						newSku.setQuantity(sku.getQuantity());
    						newSku.setSku(sku.getSku());
    						
    						storePreOrder.getSku().add(newSku);
    					}
    					orderLine.getPreOrderList().add(storePreOrder);
    					integrationEvent.getOrderLine().add(orderLine);
    				}
    			}
    			if (command.getFolios() != null) {
    				integrationEvent.setOrderId(command.getReserve().getOrderId());
    				OrderLine orderLine = new OrderLine();
        		
    				WarehousePC whpc = new WarehousePC();
					whpc.setOrderId(command.getReserve().getOrderId());
					whpc.setFolioComuna(command.getFolios().getFolioComuna());
					whpc.setObservation(command.getFolios().getObservation());
					
					
    				if (command.getFolios().getPurchaser() != null) {
    					whpc.getPurchaser().setCustomerAddress(command.getFolios().getPurchaser().getCustomerAddress());
    					whpc.getPurchaser()
    							.setCustomerDocumentNumber(command.getFolios().getPurchaser().getCustomerDocumentNumber());
    					whpc.getPurchaser()
    							.setCustomerDocumentType(command.getFolios().getPurchaser().getCustomerDocumentType());
    					whpc.getPurchaser()
    							.setCustomerLastName(command.getFolios().getPurchaser().getCustomerLastName());
    					whpc.getPurchaser().setCustomerName(command.getFolios().getPurchaser().getCustomerName());
    					whpc.getPurchaser().setCustomerPhone(command.getFolios().getPurchaser().getCustomerPhone());
    				}
    				if (command.getFolios().getReceiver() != null) {

    					whpc.getReceiver().setReceiverAddress(command.getFolios().getReceiver().getReceiverAddress());
    					whpc.getReceiver().setReceiverAddressLocationType(
    							command.getFolios().getReceiver().getReceiverAddressLocationType());
    					whpc.getReceiver()
    							.setReceiverDocumentNumber(command.getFolios().getReceiver().getReceiverDocumentNumber());
    					whpc.getReceiver()
    							.setReceiverDocumentType(command.getFolios().getReceiver().getReceiverDocumentType());
    					whpc.getReceiver().setReceiverEmail(command.getFolios().getReceiver().getReceiverEmail());
    					whpc.getReceiver().setReceiverFloor(command.getFolios().getReceiver().getReceiverFloor());
    					whpc.getReceiver().setReceiverLastName(command.getFolios().getReceiver().getReceiverLastName());
    					whpc.getReceiver().setReceiverMobile(command.getFolios().getReceiver().getReceiverMobile());
    					whpc.getReceiver().setReceiverName(command.getFolios().getReceiver().getReceiverName());
    					whpc.getReceiver().setReceiverPhone(command.getFolios().getReceiver().getReceiverPhone());
    					whpc.getReceiver()
    							.setReceiverPostalCode(command.getFolios().getReceiver().getReceiverPostalCode());
    					whpc.getReceiver()
    							.setReceiverSecondLastName(command.getFolios().getReceiver().getReceiverSecondLastName());
    				}

    				orderLine.setPc(whpc);
    				
    				for (rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Dispatch  dispatch : command.getFolios().getDispatch()) {
    					
    					
    					WarehousePreOrder warehousePreOrder = new WarehousePreOrder();
    					
    				
    					warehousePreOrder.setDeliveryWh(dispatch.getDeliveryWh());
    					warehousePreOrder.setDispatchWh(dispatch.getDispatchWh());
    					warehousePreOrder.setFolioDateDispatch(dispatch.getFolioDateDispatch());
    					warehousePreOrder.setFolioHourDispatch(dispatch.getFolioHourDispatch());
    					warehousePreOrder.setFolioPriceDispatch(dispatch.getFolioPriceDispatch());
    					warehousePreOrder.setFolioSkuDispatch(dispatch.getFolioSkuDispatch());
    					warehousePreOrder.setRutProvider(dispatch.getRutProvider());
    					warehousePreOrder.setSalesStore(dispatch.getSalesStore());
    					for (rtl.tot.corp.sche.ormg.ordermanagement.application.adapters.model.Sku sku : dispatch.getSku()) {
    						Sku newSku = new Sku();
    						
    						newSku.setQuantity(sku.getQuantity());
    						newSku.setSku(sku.getSku());

    						warehousePreOrder.getSku().add(newSku);

    					}
    					orderLine.getPreOrderList().add(warehousePreOrder);
    					integrationEvent.getOrderLine().add(orderLine);
    				}
    	        
    			}
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending OrderCreateEvent integration Event " , command.getFolios().getOrderId());
    	       	 
    	        	return publisher.publish(EventType.ORDER_CREATED, integrationEvent);
    				   	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending OrderCreateEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}