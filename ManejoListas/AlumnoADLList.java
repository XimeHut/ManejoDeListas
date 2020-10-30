import java.io.*;
import java.util.StringTokenizer;
import java.util.Date;
import java.nio.file.*; //para el if Exists 
import java.util.LinkedList;

public class AlumnoADLList
{
	//Atributos
	private AlumnoDP primero,actual,ultimo , anterior;
	private AlumnoDP posAlumno;
	private LinkedList listaAlumnos= new LinkedList(); //definir la lista clientes 
	private LinkedList listaPromedios = new LinkedList();

	//Constructor
	
	public AlumnoADLList() //pasar datos archivo a lista enlazada
	{
		datosArchivoListaAlumnos();

	
	}
		
	//Metodos de gestion de lista de Alumnos

	public String consultar()
	{
		String datos ="";
		int i = 0;
		if(listaAlumnos.isEmpty())
		{
			datos = "Lista Alumnos vacia...";
		}
		else
		{
	
			while( i < listaAlumnos.size())
			{
				actual = (AlumnoDP)listaAlumnos.get(i); //actual es tipo de clientedp , la direccion podriamos decir que es i get(indiceNodo)
				//no puedo asignar un objeto a clientedp asi que se traforma (ClienteDP)
				
				datos = datos + actual.toString() + "\n";
			
			i++;
			}
			System.out.println(datos);
		}
		
		return datos;
	}
	
	private String captura(String datos)
		
	{
   	    listaAlumnos.add(new AlumnoDP(datos)); //croe un nodo y lo adicciono a la lista , (add y add first addicionan objetos )
		return "Datos en la lista de Alumnos...";
	} 
	
	//Metodos de gestion de Promedio
	
		private String capturaP(String datos)
		
	{
   	    listaPromedios.add(new AlumnoDP(datos)); //croe un nodo y lo adicciono a la lista , (add y add first addicionan objetos )
		return "Lista Promedios de AlumnoDP creados correctamente";
	} 
	
	public  String generarListaPromedios()
	{
	 	String datos ="", respuesta="";
	 	
		int i =0;
		if(listaAlumnos.isEmpty())
		{
			respuesta = "Lista Promedios vacia...";
		}
		else
		{
			 if(listaPromedios.isEmpty()){
	
			while( i < listaAlumnos.size())
			{
					actual = (AlumnoDP)listaAlumnos.get(i); 
					if(actual.getPromedio() >= 90 ){
						datos = actual.toString();
						capturaP(datos);
						
					}
					i++;
				}
			respuesta = "Lista Promedios de AlumnoDP creada correctamente";
			}
			else
			{
				respuesta = "Lista ya creada";
			}
			 			
			
	}
	return respuesta;
	
	}
	
	
	private  String crearNodoPromedios(String datos)
	{
		String respuesta="";
		listaAlumnos.add(new AlumnoDP(datos));
		
		return "Lista Promedios de AlumnoDP creada correctamente...";
	  }
	
	public String consultarListaPromedios()
	{
		String datos ="";
	
		int i =0;
		if(listaPromedios.isEmpty())
		{
			datos = "Lista Promedio vacia...";
		}
		
		else
		{
	       
	        	
		        while( i < listaPromedios.size())
				{
					actual = (AlumnoDP)listaPromedios.get(i); //actual es tipo de clientedp , la direccion podriamos decir que es i get(indiceNodo)
					//no puedo asignar un objeto a clientedp asi que se traforma (ClienteDP)
					
					datos = datos + actual.toString() + "\n";
				
				i++;
				}
			
	        	
		
			System.out.println(datos);
		}
		
		return datos;
	}

	public String calcularPromedios(){
		
		    String datos="";
		 	String datosPromedio="" , datosImprimir="";
		 	String respuesta="";
		 	float  suma=0 , promedio =0;
		 	int i = 0;
		 	
			if(listaAlumnos.isEmpty())
			{
			datos = "Lista vacia...";
			}
			else
		{
			//ciclo
			while( i < listaAlumnos.size())
			{
				actual = (AlumnoDP)listaAlumnos.get(i);
			//	datos = datos + actual.toString() + "\n";
			suma = (actual.getParcial1() + actual.getParcial2() +actual.getParcial3());
		    promedio = (suma/3);
		
		    //datosPromedio = datosPromedio + actual.getMatricula()+"_"+actual.getNombre()+"_"+actual.getCarrera()+"_"+actual.getParcial1()+"_"+actual.getParcial2()+"_"+actual.getParcial3();
	    	actual.setPromedio(promedio);
	    	//datosPromedio = datosPromedio +"_"+actual.getPromedio();
	    //	datosImprimir = datosPromedio+"_"+actual.getPromedio()+"\n";
			i++;
			}
			
		}
		
		   // actual=posCliente;
		
		
		  
	//	System.out.println(datosImprimir);
		respuesta = "Promedios Calculados";
	//	respuesta = crearNodoPromedios(datosPromedio);
	
	    return respuesta;
	  }	
	  
  
  //Metodos de gestion de archivos y listas
  	
  	
  	public String datosListaArchivo()
  	{
  		String resultado="",datos ="";
  		PrintWriter archivoOut;
  		int i =0;
  		
  		
		if(listaAlumnos.isEmpty())
		{
			datos = "Lista vacia...";
			try{ 
	            Files.deleteIfExists(Paths.get("Alumnos.txt"));  // solo existe , para cuendo queda solo uno y lo quiero borrar
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
				archivoOut = new PrintWriter(new FileWriter("Alumnos.txt"));
				//actual = primero;
				//ciclo
				while(i <listaAlumnos.size())
				{
					//datos = datos + actual.toString();
				actual = (AlumnoDP)listaAlumnos.get(i);
				datos = datos + actual.toString() +"\n";
				i++;
				}	
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
	
	public String datosListaPromediosArchivo()
	{
		String resultado="",datos ="";
  		PrintWriter archivoOut;
  		int i =0;
  		
  		
		if(listaPromedios.isEmpty())
		{
			datos = "Lista Promedio vacia...";
		}
		else
			
		{
			try 
			{
				//actual me va a ayudar a hacer el recorrido de la lista 
				archivoOut = new PrintWriter(new FileWriter("Alumnos.txt"));
			
				while(i< listaPromedios.size())
				{
					//datos = datos + actual.toString();
					archivoOut.println(actual.toString());
					i++;
					//actual = actual.getNext(); // getNext es el accesor que me va dar la direccion del siguiente elemento
				}	
					archivoOut.close();
					resultado="Datos de la Lista almacenados en el archivo Promedios.txt....";
			}
			catch(IOException ioe)
			{
				resultado ="ERROR: "+ioe;
				System.out.println("Error: +ioe");
						
			}
	
		}
		
  		return resultado;
	}
	
	public void datosArchivoListaPromedios()
	{
		try
		{
			BufferedReader archivoIn = new BufferedReader(new FileReader("Alumnos.txt"));
			while(archivoIn.ready())
				crearNodoPromedios(archivoIn.readLine());
				
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

