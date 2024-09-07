
package jaimemanga.imc.rmi.net;

import jaimemanga.imc.rmi.lib.IRemotaCalculoImc;
import java.io.IOException;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

public class Servidor {
    private int port = 9007;
    private CallHandler summoner;
    private Server servidor;
    private CalculoRmiImcImplemt calculateImc;
    private IRemotaCalculoImc remoteImcCalculator;
    
    public Servidor(){
        summoner = new CallHandler();
        servidor = new Server();
        calculateImc = new CalculoRmiImcImplemt();
    }
    
    public void iniciar() throws Exception {
      try{
      summoner.registerGlobal(IRemotaCalculoImc.class, calculateImc);
      servidor.bind(port, summoner);
      }catch(LipeRMIException ex){
          throw new Exception("Error: no es posible invocar metodos remotos");
      }catch(IOException ex){
          throw new Exception("Error I/O");
      }
    }
    
    public void detener(){
        servidor.close();
    }
    
}
