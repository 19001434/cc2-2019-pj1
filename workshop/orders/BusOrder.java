package workshop.orders;
public class BusOrder extends PaintOrder{
    protected double price;
    public BusOrder(int number, String plate, int total, double time, int price){
    	super(number, plate, total, time);
    	this.price = price;
    	painted = 0;
        state = State.WAITING;
    }
    //Devuelve el tipo de orden
    public String getType(){
    	return "MICROBUS";
    }
    //devuelve el precio
    public String getPrice(){
    	String precio = "";
    	//esta completa la orden?
    	if(this.getPainted()==total){
    		//Extraer el ultimo numero de la placa
    		Double n_descuento = Double.parseDouble(this.getLicensePlate().substring(2,3));
    		//Porcentaje de descuento
    		double off = n_descuento/100;
    		//Precio con descuento aplicado
    		precio = Double.toString(this.price-(this.price*off));
    	} else {
    		precio = "?";
    	}
    	return precio;
    }
    public void waiting(){
    	this.state = State.WAITING;
    }
    public void end(){
    	this.state = State.END;
    }
    public void paint(int pieces) throws Exception {
        if (pieces > (this.total - this.painted) || pieces <= 0) {
            throw new Exception("Error, cantidad de piezas por pintar incorrecta");
        }
        this.state = State.WAITING;
        this.painted = this.painted + pieces;
    }
    public int getOrder(){
    	return number;
    }
    public int getPainted(){
    	return painted;
    }
    public int getTotal(){
    	return total;
    }
    public double getTime(){
    	return time;
    }
    public String getLicensePlate(){
    	return state;
    }
    public State getState(){
    	return state;
    }
    public final String toString() {
        return String.format("[#%d - place=%s - piezas=%d/%d - estado=%s - tipo=%s - pago=Q%s]",
            number,
            plate,
            painted,
            total,
            state,
            getType(),
            getPrice()
        );
    }

}