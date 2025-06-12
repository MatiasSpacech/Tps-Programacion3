public class Maquina implements Comparable<Maquina> {
    private String nombre;
    private Integer piezas;

    public Maquina(String nombre, int piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    @Override
    public String toString() {
        return " [Maquina=" + nombre + ", piezas=" + piezas + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Maquina other = (Maquina) obj;
        if (piezas != other.piezas)
            return false;
        return true;
    }

    @Override
    public int compareTo(Maquina o) {
        return this.piezas.compareTo(o.getPiezas());
    }

}
