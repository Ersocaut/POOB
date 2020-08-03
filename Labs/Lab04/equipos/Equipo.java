import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }    
    }

    /**
     * Calcula el valor hora de un equipo
     */

    public int valorHora() throws EquipoExcepcion{
        int valorHora =0;

        if (personas.size()==0){
            throw  new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        } 
        for(Persona i: personas){
            Integer tempValue=i.valorHora();
            valorHora+=tempValue;
            Integer numero=i.valorHora();
            if (numero==null) {
                throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
            }
            if (numero==0){
                throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
            }
        }
        return valorHora;
    }

    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor estimado de una persona a la que no se conoce su valor es la
     * media de los valores conocidos
     * Más del 75% del equipo debe tener valores conocidos 
     * @return el valor hora del equipo
     * @throws EquipoException si en el equipo hay una persona desconocida
     * o si no es posible calular el valor estimado
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int personasConocidas=0;
        int minimo=(75*personas.size())/100;
        int con=0;
        if(personas.size()==0){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        for(Persona i: personas){
            try{
                valorHora();
                personasConocidas++;
            }
            catch(EquipoExcepcion e){
                if(EquipoExcepcion.VALOR_DESCONOCIDO.equals(e.getMessage())){
                    con++;
                }
                else{
                    throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
                }
            }
        }
        if(personasConocidas<=(75*personas.size())/100) 
        {
            throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
        }
        int valorHoras=valorHora()+(valorHora()/personasConocidas)*con;
        return valorHoras;
    }
}
