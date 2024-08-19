public class ColeccionVinilos {

    public static void main(String[] args){
        String vinilos[][] = new String [100][3];

        agregarVinilo(vinilos,"Iron Maiden","Iron Maiden","1980");
        agregarVinilo(vinilos,"Iron Maiden","Killers","1981");
        agregarVinilo(vinilos,"Iron Maiden","The number of the beast","1982");
        agregarVinilo(vinilos,"AC-DC","Back in black","1980");
        agregarVinilo(vinilos,"AC-DC","Highway to Hell","1979");
        agregarVinilo(vinilos,"AC-DC","Who made who","1986");
        agregarVinilo(vinilos,"Judas Priest","British steel","1980");
        agregarVinilo(vinilos,"Judas Priest","Painkiller","1980");
        agregarVinilo(vinilos,"Judas Priest","Defenders of the faith","1984");
        agregarVinilo(vinilos,"Kiss","Destroyer","1976");

        System.out.println("Espacio máximo colección: "+vinilos.length);

        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "AC-DC";
        System.out.println("Buscar artista: "+artista);
        mostrarBusquedaArtista(vinilos,artista);

        buscarArtista(vinilos,artista);
        mostrarColeccion(vinilos);
    }

    public static int totalVinilos(String m[][]) {
        int totalFilasNoNulas = 0;
        for (String[] row : m) {
            boolean filaNoNula = false;
            for (String element : row) {
                if (element != null) {
                    filaNoNula = true;
                    break;
                }
            }
            if (filaNoNula) {
                totalFilasNoNulas++;
            }
        }
        return totalFilasNoNulas;
    }

    public static void agregarVinilo(String[][] m, String gru, String lp, String agno) {
        String[] cadena = {gru, lp, agno};
        for (int i = 0; i < m.length; i++) {
            boolean filaVacia = true;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != null && !m[i][j].isEmpty()) {
                    filaVacia = false;
                    break;
                }
            }
            if (filaVacia) {
                m[i] = cadena;
                return;
            }
        }
        System.out.println("No hay espacio disponible para agregar la nueva cadena.");
    }

    public static boolean buscarArtista(String m[][],String artista){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j].equals(artista)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void mostrarColeccion(String m[][]){
        for (int i = 0; i < m.length; i++) {
            boolean filaNoNula = false;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != null) {
                    filaNoNula = true;
                    break;
                }
            }
            if (filaNoNula) {
                System.out.println("Fila " + (i + 1) + ": " + m[i][0] + " - " + m[i][1] + " - " + m[i][2]);
            }
        }
    }

    public static void mostrarTotal(String m[][]){
        int total = totalVinilos(m);
        System.out.println("Hay un total de: " + total + " vinilos en la colección");
    }

    public static void mostrarDisponibles(String m[][]){
        int disponible = disponibles(m);
        System.out.println("Hay un total de: " + disponible + " espacios disponibles en la coleccion");
    }

    public static int disponibles(String m[][]){
        int totalFilasNulas = 0;
        for (String[] row : m) {
            boolean filaNula = true;
            for (String element : row) {
                if (element != null) {
                    filaNula = false;
                    break;
                }
            }
            if (filaNula) {
                totalFilasNulas++;
            }
        }
        return totalFilasNulas;
    }

    public static void mostrarBusquedaArtista(String m[][],String artista){
        boolean estado = buscarArtista(m,artista);
        if (estado){
            System.out.println("El artista " + artista + " sí está en la colección.");
        } else {
            System.out.println("Artista no encontrado.");
        }
    }
}
