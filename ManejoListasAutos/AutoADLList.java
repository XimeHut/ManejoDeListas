import java.io.*;
import java.util.StringTokenizer;
import java.util.Date;
import java.nio.file.*; //para el if Exists 
import java.util.LinkedList;

public class AutoADLList {

	
	//Atributos 
	private AutoDP primero,actual,ultimo , anterior;
	private VentaDP primeroVenta , actualVenta, ultimoVenta , anteriorVenta;
	private AutoDP posAuto;
	
	
	//Atributos de LinkedList 
	private LinkedList listaAutos= new LinkedList(); //definir la lista clientes 
	private LinkedList listaVentas = new LinkedList();
	
	private int nodoActual;

	public AutoADLList() //contructor 
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
		listaAutos.add(new AutoDP(datos)); //croe un nodo y lo adicciono a la lista , (add y add first addicionan objetos )
		return "Datos en la lista de Autos....";
	}

    public String consultar()

    {
    	
  		String datos ="";
  		int i =0;

		if(listaAutos.isEmpty())
		{
			datos = "Lista vacia...";
		}
		else
		{
			while(i<listaAutos.size())
			{
				actual = (AutoDP)listaAutos.get(i);
				datos = datos + actual.toString() + "\n";
				i++;
		
			}
		}
		
		return datos;
   
    }   
    
    public String  consultarClave(String clue){
    	
	String datos="";
		 Boolean encontrado=false;
		 int i =0;
		
		   if(listaAutos.isEmpty()){		   
		      datos="LISTA_VACIA";
		    }
		
		    else{
		      while(i<listaAutos.size() && !encontrado)
		      {
		      	actual = (AutoDP)listaAutos.get(i);
		      
		        if(actual.getClave().equals(clue)){
		          datos=datos+actual.toString();
		          nodoActual = i;
		          encontrado=true;
		        }
		        i++;
		   
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
		int i =0;
			
		if(listaAutos.isEmpty())
		{
			datos = "Lista vacia...";
		}
		else
		{
			while(i<listaAutos.size())
			{
				if(actual.getMarca().equals(marc)){
					datos = datos +actual.toString() + "\n";	
					encontrado=true;
				}
			i++;
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

//	actual=posAuto;		
		
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
		
		listaVentas.add(new VentaDP(datos));
	
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
			
	//	actual=posAuto;
		
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
  		int i =0;

		if(listaVentas.isEmpty())
		{
			datos = "Lista Ventas  vacia...";
		}
		else
		{
			while(i<listaVentas.size())
			{
				actualVenta = (VentaDP)listaVentas.get(i);
				datos = datos + actualVenta.toString() + "\n";
				i++;
		
			}
		}
		
		return datos;	
  	}
  
////////////////	

	public String datosListaArchivo()
	{
		String resultado="",datos ="";
  		PrintWriter archivoOut;
  		int i=0;
  		
  		
		//if (primero == null)
		if(listaAutos.isEmpty())
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
			//	actual = primero;
				//ciclo
			//	while(actual !=null)
			while (i< listaAutos.size())
				{
					actual = (AutoDP)listaAutos.get(i);
					//datos = datos + actual.toString();
					archivoOut.println(actual.toString());
					//actual = actual.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
					i++;
				}	
					archivoOut.close();
					resultado="Datos de la Lista almacenados en el archivo....";
			}
			catch(IOException ioe)
			{
				resultado ="ERROR: "+ioe;
				System.out.println("Error: +ioe");
						
			}
	
		}
		
  		return resultado;
  		
  	}
	
	public String datosListaVentasArchivo()
	{
		
		String resultado="",datos ="";
  		PrintWriter archivoOut;
  		int i =0;
  		
  		
		//if (primeroDeposito == null)
		if(listaVentas.isEmpty())
		{
			datos = "Lista Ventas vacia...";
		}
		else
			
		{
			try 
			{
				//actual me va a ayudar a hacer el recorrido de la lista 
				archivoOut = new PrintWriter(new FileWriter("Ventas.txt"));
				
			//	actualDeposito = primeroDeposito;
				//ciclo
			//	while(actualDeposito !=null)
			while(i< listaVentas.size())
				{
					//datos = datos + actual.toString();
					archivoOut.println(actualVenta.toString());
				//	actualDeposito = actualDeposito.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
				i++;
				}	
					archivoOut.close();
					resultado="Datos de la Lista almacenados en el archivo Ventas.txt....";
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
    }
    
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
		
	}	
		
	
		
	
	}
  	


