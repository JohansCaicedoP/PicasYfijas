package core;

import java.util.Random;

/**
 *
 * @author johan
 */
public class Core {

    public Random aleatorio = new Random();
    public String numInput = " ";
    public String resul = "RESULTADO";
    public int fija;
    public int pica;
    public int paso;
    public boolean estado = false;
    char numGen[] = new char[4]; //arreglo que almacenara el numero de 4 digitos generado 

    /**
     * @author Johans Caicedo
     */
    public void randLoadCuda() {
        try{
            Process demon = Runtime.getRuntime().exec("randomFog.exe");
            
        }catch(Exception e){
            System.out.println("Error al cargar el cuda"+e.getMessage());
        }
    }

    public Random getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

    public String getNumInput() {
        return numInput;
    }

    public void setNumInput(String numInput) {
        this.numInput = numInput;
    }

    public String getResul() {
        return resul;
    }

    public void setResul(String resul) {
        this.resul = resul;
    }

    public int getFija() {
        return fija;
    }

    public void setFija(int fija) {
        this.fija = fija;
    }

    public int getPica() {
        return pica;
    }

    public void setPica(int pica) {
        this.pica = pica;
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public char[] getNumGen() {
        return numGen;
    }

    public void setNumGen(char[] numGen) {
        this.numGen = numGen;
    }

    /**
     *
     */
    public void randLoad() {
        int i = 0, num;
        while (i < 4) {
            paso = 0;
            num = aleatorio.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (numGen[j] == (char) (num + 48)) {
                    paso = 1;
                }
            }
            if (paso == 0) {
                numGen[i] = (char) (num + 48);
                i++;
            }
        }
    }

    public boolean compara() {
        int i, j;
        char[] arrIngr = this.numInput.toCharArray();
        fija = pica = 0;
        for (i = 0; i < numGen.length; i++) {
            for (j = 0; j < 4; j++) {
                if (i == j) {
                    if (numGen[i] == arrIngr[j]) {
                        fija++;
                        break;
                    }
                } else {
                    if (numGen[i] == arrIngr[j]) {
                        pica++;
                        break;
                    }
                }
            }
        }
        return false;
    }
}
