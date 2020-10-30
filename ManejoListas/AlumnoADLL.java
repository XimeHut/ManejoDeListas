import java.io.*;
import java.util.StringTokenizer;
import java.util.Date;
import java.nio.file.*; //para el if Exists 

public class AlumnoADLL
{
	//Atributos
	private AlumnoDP primero,actual,ultimo , anterior;
	private AlumnoDP primeroP,actualP,ultimoP , anteriorP;
	private AlumnoDP posAlumno;

	//Constructor
	
	public AlumnoADLL() //pasar datos archivo a lista enlazada
	{
		datosArchivoListaAlumnos();
	
	
	}
		
	//Metodos de gestion de lista de Alumnos

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
			System.out.println(datos);
		}
		
		return datos;
	}
	
	private String captura(String datos)
		
	{
		if(primero == null)
		{
			primero = new AlumnoDP(datos); //se crea una direccion en memoria y se la asigno a 
			ultimo = primero; //ultimo apunte a primero
			ultimo.setNext(null); //acceros de ultimo 
		
		}
		else
		{
			actual = new AlumnoDP(datos);	
			ultimo.setNext(actual); //enlace entre nodos
			ultimo = actual;
			ultimo.setNext(null);
		}
		return "Nuevo nodo creado en la lista:" +ultimo.toString();
	} 
	
	private  String crearNodoPromedios(String datos)
	{
		String respuesta = "";
		if(primeroP == null){
			primeroP = new AlumnoDP(datos);
			ultimoP = primeroP;
			ultimoP.setNext(null);
		}
		else{
			actualP = new AlumnoDP(datos);
			ultimoP.setNext(actualP);
			ultimoP = actualP;
			ultimoP.setNext(null);
		}
		
		return "Lista Promedios de AlumnoDP creada correctamente...";
		
	
	  }
	
	//Metodos de gestion de Promedio
	public String generarListaPromedios()
	{
		String respuesta="";
	
		if(primero == null){
			respuesta =  "Lista de Alumnos vacia";
			
		}
		else 
		{
			if(primeroP == null){
				
				actual = primero;
				while(actual != null){
			
								if(actual.getPromedio() >= 90.0){
									System.out.println(actual.getPromedio());
									crearNodoPromedios(actual.toString());
									
								}
								actual = actual.getNext();								
					}	
				respuesta = "Lista Promedios de AlumnoDP creada correctamente";
					
			}
			else{
				respuesta = "Lista ya creada";
			}
	
		}
		return respuesta;
	}
	
	public String consultarListaPromedios()
	{
		String datos="";
	
	
		if(primeroP == null) ////
		{
			datos="Lista de Promedios Vacia";
		}
				
		else
		{
			actualP = primeroP;
			while(actualP != null) //que sea diferente
			{
				datos = datos + actualP.toString() +"\n";
				actualP = actualP.getNext();
			}
		}
	return datos;
	}

	public String calcularPromedios(){
		
		    String datos="";
		 	String datosPromedio="";
		 	String respuesta="";
		 	float  suma=0 , promedio =0;
		 	
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
			//	datos = datos + actual.toString() + "\n";
			suma = (actual.getParcial1() + actual.getParcial2() +actual.getParcial3());
		    promedio = (suma/3);
		
		    //datosPromedio = datosPromedio + actual.getMatricula()+"_"+actual.getNombre()+"_"+actual.getCarrera()+"_"+actual.getParcial1()+"_"+actual.getParcial2()+"_"+actual.getParcial3();
	    	actual.setPromedio(promedio);
	    	//datosPromedio = datosPromedio +"_"+ actual.getPromedio();
			actual = actual.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
			respuesta = "Promedios calculados"; 
			}
			//System.out.println(datos);
		}
		
		   // actual=posCliente;
		
		
		  
		//System.out.println(datosPromedio);
		//respuesta = crearNodoPromedios(datosPromedio);
	
	    return respuesta;
	  }	
	  
  
  //Metodos de gestion de archivos y listas
  	
  	
	public void datosArchivoListaAlumnos()
	{
		try
		{
			BufferedReader archivoIn = new BufferedReader(new FileReader("Alumnos.txt"));
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
	

	
}

