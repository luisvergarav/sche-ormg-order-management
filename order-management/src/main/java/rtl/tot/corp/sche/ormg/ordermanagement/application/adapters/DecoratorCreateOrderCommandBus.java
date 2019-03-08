package rtl.tot.corp.sche.ormg.ordermanagement.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.events.OrderCreatedIntegrationEvent;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.EventType;
import rtl.tot.corp.sche.ormg.ordermanagement.domain.ports.CommandBus;
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