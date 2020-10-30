import java.util.StringTokenizer;

public class VentaDP
{
    // Atributos
    private String clave, marca, tipo,interes;
    private int precio,plazo;
    private float precioTotal , mensualidad;
    
     private VentaDP next;

    // Constructors
    public VentaDP()
    {
        this.clave  = "";
        this.marca  = "";
        this.tipo   = "";
        this.precio = 0;
        
        this.interes = "";
        this.plazo = 0;
        this.precioTotal = 0;
        this.mensualidad=0;
    }

    public VentaDP(String datos)
    {
        StringTokenizer st = new StringTokenizer(datos,"_");

        this.clave  = st.nextToken();
        this.marca  = st.nextToken();
        this.tipo   = st.nextToken();
        this.precio = Integer.parseInt(st.nextToken());
        this.plazo = Integer.parseInt(st.nextToken());
        this.interes = st.nextToken();
        this.precioTotal = Float.parseFloat(st.nextToken());
        this.mensualidad=Float.parseFloat(st.nextToken());
    }
    
    // Accesors
    public String getClave()
    {
        return this.clave;
    }
    
    public String getMarca()
    {
        return this.marca;
    }
    
    public String getTipo()
    {
        return this.tipo;
    }
    
    public int getPrecio()
    {
        return this.precio;
    }
    
      public int getPlazo()
    {
        return this.plazo;
    }
    
       public String getInteres()
    {
        return this.tipo;
    }
    
    public float getPrecioTotal()
    {
    	return this.precioTotal;
    }
    public float getMensualidad()
    {
    	return this.mensualidad;
    }
    	 public VentaDP getNext()
    {
        return this.next;
    }
    // Mutators
    public void setClave(String cve)
    {
        this.clave = cve;
    }
    
    public void setMarca(String mca)
    {
        this.marca = mca;
    }
    
    public void setTipo(String tpo)
    {
        this.tipo = tpo;
    }
    
    public void setPrecio(int pre)
    {
        this.precio = pre;
    }
     public void setNext(VentaDP nodo)//voy a recibir de parametro un objeto de tipo DP
    {
    	this.next = nodo;
    }
    
    public String toString()
    {
        return this.clave+"_"+this.marca+"_"+this.tipo+"_"+this.precio+"_"+this.plazo+"_"+this.interes+"_"+this.precioTotal+"_"+this.mensualidad;
    }
}
