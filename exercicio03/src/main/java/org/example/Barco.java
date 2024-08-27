class Barco {
    String nome;
    int tamanho;

    public Barco(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }
}

class BasePorto {
    String nome;
    Barco[] barcosAtracados;
    int index = 0;

    public BasePorto(String nome, int capacidade) {
        this.nome = nome;
        this.barcosAtracados = new Barco[capacidade];
    }

    public boolean atracarBarco(Barco barco) {
        if (index < barcosAtracados.length) {
            barcosAtracados[index] = barco;
            index++;
            System.out.println(barco.nome + " atracado no " + nome);
            return true;
        } else {
            System.out.println("Sem espaço no " + nome + " para " + barco.nome);
            return false;
        }
    }

    public void desatracarBarco(Barco barco) {
        for (int i = 0; i < index; i++) {
            if (barcosAtracados[i] == barco) {
                System.out.println(barco.nome + " desatracado do " + nome);
                barcosAtracados[i] = null;
                reorganizarPorto(i);
                index--;
                break;
            }
        }
    }

    private void reorganizarPorto(int posicao) {
        for (int i = posicao; i < index - 1; i++) {
            barcosAtracados[i] = barcosAtracados[i + 1];
        }
        barcosAtracados[index - 1] = null;
    }
}

class PortoPequeno extends BasePorto {
    public PortoPequeno(String nome, int capacidade) {
        super(nome, capacidade);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho <= 10) {
            return super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " não pode atracar no " + nome + " devido ao tamanho.");
            return false;
        }
    }
}

class PortoGrande extends BasePorto {
    public PortoGrande(String nome, int capacidade) {
        super(nome, capacidade);
    }

    @Override
    public boolean atracarBarco(Barco barco) {
        if (barco.tamanho > 10) {
            return super.atracarBarco(barco);
        } else {
            System.out.println(barco.nome + " não pode atracar no " + nome + " devido ao tamanho.");
            return false;
        }
    }
}
