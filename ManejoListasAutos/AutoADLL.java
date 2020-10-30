import java.io.*;
import java.util.StringTokenizer;
import java.util.Date;
import java.nio.file.*; //para el if Exists 

public class AutoADLL {

	
	//Atributos 
	private AutoDP primero,actual,ultimo , anterior;
	private VentaDP primeroVenta , actualVenta, ultimoVenta , anteriorVenta;
	private AutoDP posAuto;
	
	

	public AutoADLL() //contructor 
	{
	 datosArchivoListaAutos();
	 datosArchivoListaVentas();
	}
	
	public String capturar(String datos)
		
	{
		String respuesta="", resultado="";
		StringTokenizer st = new StringTokenizer(datos,"_");
		String clave = st.nextToken();
		
		 respuesta = consultarClave(clave);
			
		if(respuesta.equals("LISTA_VACIA") || respuesta.equals("NOT_FOUND"))
			resultado = captura(datos);
		else
			resultado = "El no.de cuenta ya existe....";
				
		return resultado;
	}
	
	private String captura(String datos)
		
	{
		if(primero == null)
		{
			primero = new AutoDP(datos); //se crea una direccion en memoria y se la asigno a 
			ultimo = primero; //ultimo apunte a primero
			ultimo.setNext(null); //acceros de ultimo 
			System.out.println(ultimo);
		}
		else
		{
			actual = new AutoDP(datos);	
			ultimo.setNext(actual); //enlace entre nodos
			ultimo = actual;
			ultimo.setNext(null);
		}
		return "Nuevo nodo creado en la lista:" +ultimo.toString();
	}

    public String consultar()

    {
    	
  		String datos ="";
		if (primero == null)
		{
			datos = "Lista vacia...";
		}
		else
		{
			//actual me va a ayudar a hacer el recorrido de la lista 
			actual = primero;
			//ciclo
			while(actual !=null)
			{
				datos = datos + actual.toString() + "\n";
				actual = actual.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
			}
		}
		
		return datos;
   
    }   
    
    public String  consultarClave(String clue){
    	
    		
    	String datos="";
		 Boolean encontrado=false;
		
		    if(primero==null){
		      datos="LISTA_VACIA";
		    }
		
		    else{
		      actual=primero;
		      while(actual!=null && !encontrado){
		        if(actual.getClave().equals(clue)){
		          datos=datos+actual.toString();
		          posAuto=actual;
		          encontrado=true;
		        }
		        else
		        	anterior = actual; ///
		        	
		        actual=actual.getNext();
		      }
		      if(encontrado==false){
		        datos="NOT_FOUND";
		      }
		    }
		    System.out.println(posAuto);
		    return datos;
			
    
    }	
    
    public String consultarMarca(String marc)
    {
    	String datos ="";
		boolean encontrado = false;
			
		if (primero == null)
		{
			datos = "Lista vacia...";
		}
		else
		{
			actual = primero; //para empezar a hacer el recorido
			
			while(actual !=null)
			{
				if(actual.getMarca().equals(marc)){
					datos = datos +actual.toString() + "\n";	
					encontrado=true;
				}
				actual = actual.getNext();
			}
		if (!encontrado)
		{
			datos = "No se localizo la marca"+marc;
		}	
			
		}
		
		
		return datos;
    }

    public String cotizarAuto(int plazo){
		
	String cotiza = "COTIZACION AUTOMOVIL: \n";
	String strInteres="";
	float precioTotal=0, mensualidad=0,interes=0;

	actual=posAuto;		
		
		if (plazo == 12)
		{
			interes = (float)(0.10);
			precioTotal = actual.getPrecio() * interes + actual.getPrecio();
			mensualidad = precioTotal/plazo;
			strInteres = "10 %";
			System.out.println(actual.getPrecio());
		
		}
		
			if (plazo == 24)
		{
			interes = (float)(0.15);
			precioTotal = actual.getPrecio() * interes + actual.getPrecio();
			mensualidad = precioTotal/plazo;
			strInteres = "15 %";
		
		}
			if (plazo == 48)
		{
			interes = (float)(0.20);
			precioTotal = actual.getPrecio() * interes + actual.getPrecio();
			mensualidad = precioTotal/plazo;
			strInteres = "20 %";
		
		}
		
		
		  cotiza=cotiza+"Clave Auto: "+actual.getClave()+"\nTipo: "+actual.getTipo()+"\nPrecio Contado: "+actual.getPrecio()+"\nPlazo"+plazo+" Meses\nIntereses: "+strInteres+"\nPrecio con interes "+precioTotal+"\nMensualidad: "+mensualidad;
  
			return cotiza;
	}
	
	private  String crearNodoVentas(String datos)
	{
		String respuesta="";
		if(primeroVenta==null)
		{
			primeroVenta = new VentaDP(datos);
			ultimoVenta = primeroVenta;
			ultimoVenta.setNext(null);
		}
		else
		{
			actualVenta = new VentaDP(datos);
			ultimoVenta.setNext(actualVenta);//Enlace entre nodos
			ultimoVenta = actualVenta;
			ultimoVenta.setNext(null); //lo aterrizamos , nos aseguramos que el ultimo elemento tenga null
			
		}
		respuesta = "Nuevo nodo Venta creado";
		
		return respuesta;
	  }
	  
    public String venta(int plazo)
  	{
  	 
  	 	String resultado,respuesta;
  	 
  	 	String datosVenta ="";
  	    String strInteres="";
  	    String datosCaptura ="";
  	   
  	  
	    float precioTotal=0, mensualidad=0,interes=0;
			
		actual=posAuto;
		
			if (plazo == 12)
		{
			interes = (float)(0.10);
			precioTotal = actual.getPrecio() * interes + actual.getPrecio();
			mensualidad = precioTotal/plazo;
			strInteres = "10 %";
		//	System.out.println(actual.getPrecio());
		
		}
		
			if (plazo == 24)
		{
			interes = (float)(0.15);
			precioTotal = actual.getPrecio() * interes + actual.getPrecio();
			mensualidad = precioTotal/plazo;
			strInteres = "15 %";
		
		}
			if (plazo == 48)
		{
			interes = (float)(0.20);
			precioTotal = actual.getPrecio() * interes + actual.getPrecio();
			mensualidad = precioTotal/plazo;
			strInteres = "20 %";
		
		}
		
  	 	datosVenta= "Clave:"+actual.getClave()+"\nMarca:"+actual.getMarca()+"\nTipo:"+actual.getTipo()+"\nPrecio Contado:"+actual.getPrecio()+"\nPlazo: "+plazo+"\nInteres: "+strInteres+"\nPrecio Total: "+precioTotal+"\nMensualidad: "+mensualidad;
  		datosCaptura=actual.getClave()+"_"+actual.getMarca()+"_"+actual.getTipo()+"_"+actual.getPrecio()+"_"+plazo+"_"+strInteres+"_"+precioTotal+"_"+mensualidad;
  		//resultado = datosVenta;
  		
  		System.out.println(datosVenta);
  		System.out.println(datosCaptura);
  		respuesta = datosVenta +"\n" +crearNodoVentas(datosCaptura);
  		
  		return respuesta;
  	}
  	
  	public String consultarVentas()
  	
  		{
		String datos ="";
		if (primeroVenta == null)
		{
			datos = "Lista vacia...";
		}
		else
		{
			//actual me va a ayudar a hacer el recorrido de la lista 
			actualVenta = primeroVenta;
			//ciclo
			while(actualVenta !=null)
			{
				datos = datos + actualVenta.toString() + "\n";
				actualVenta = actualVenta.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
			}
		}
		
		return datos;	
  	}
  
	///////////////
	public String datosListaArchivo()
	{
		String resultado="",datos ="";
  		PrintWriter archivoOut;
  		
  		
		if (primero == null)
		{
			datos = "Lista vacia...";
			try{ 
	            Files.deleteIfExists(Paths.get("Autos.txt"));  // solo existe , para cuendo queda solo uno y lo quiero borrar
	        } 
	        catch(NoSuchFileException nsfe){ 
	            System.out.println(nsfe); 
	        }
	        catch(IOException ioe){
	            System.out.println(ioe); 
	        }
		}
		else
			
		{
			try 
			{
				//actual me va a ayudar a hacer el recorrido de la lista 
				archivoOut = new PrintWriter(new FileWriter("Autos.txt"));
				actual = primero;
				//ciclo
				while(actual !=null)
				{
					//datos = datos + actual.toString();
					archivoOut.println(actual.toString());
					actual = actual.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
				}	
					archivoOut.close();
					resultado="Datos de la Lista almacenados en el archivo....";
			}
			catch(IOException ioe)
			{
				resultado ="ERROR: "+ioe;
				System.out.println("Error:" +ioe);
						
			}
	
		}
		
  		return resultado;
  			
	}
	
	public String datosListaVentasArchivo()
	{
			String resultado="",datos ="";
  		PrintWriter archivoOut;
  		
  		
		if (primeroVenta == null)
		{
			datos = "Lista Deposito vacia...";
		}
		else
			
		{
			try 
			{
				//actual me va a ayudar a hacer el recorrido de la lista 
				archivoOut = new PrintWriter(new FileWriter("Ventas.txt"));
				actualVenta = primeroVenta;
				//ciclo
				while(actualVenta !=null)
				{
					//datos = datos + actual.toString();
					archivoOut.println(actualVenta.toString());
					actualVenta = actualVenta.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
				}	
					archivoOut.close();
					resultado="Datos de la Lista almacenados en el archivo Venta.txt....";
			}
			catch(IOException ioe)
			{
				resultado ="ERROR: "+ioe;
				System.out.println("Error: +ioe");
						
			}
	
		}
		
  		return resultado;	
  	
	}
	
  	public void datosArchivoListaAutos()
	{
		try
		{
			BufferedReader archivoIn = new BufferedReader(new FileReader("Autos.txt"));
			while(archivoIn.ready())
				captura(archivoIn.readLine());
				
				archivoIn.close();	
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}
	
	
	}	////
			
	public void datosArchivoListaVentas()
	{
			try
		{
			BufferedReader archivoIn = new BufferedReader(new FileReader("Ventas.txt"));
			while(archivoIn.ready())
				crearNodoVentas(archivoIn.readLine());
				
				archivoIn.close();	
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}
		
	}	/////
		
	
	}
  	


