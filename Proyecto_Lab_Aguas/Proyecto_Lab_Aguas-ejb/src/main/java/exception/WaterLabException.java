package exception;

public class WaterLabException extends Exception{
    public WaterLabException(){
    
    }
    public WaterLabException(String mensaje){
        super(mensaje);
    }
}
