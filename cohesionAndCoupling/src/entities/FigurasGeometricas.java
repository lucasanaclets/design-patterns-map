package entities;

import exceptions.FiguraException;

public class FigurasGeometricas {
    public enum tiposDeFigura{
        QUADRADO,
        CIRCULO,
        RETANGULO,
        TODOS
    };

    private Retangulo retangulo;
    private Quadrado quadrado;
    private Circulo circulo;

    public FigurasGeometricas(
            double alturaRetangulo,
            double larguraRetangulo,
            double comprimentoLadoQuadrado,
            double raioCirculo
    ) throws FiguraException {
        this.retangulo = new Retangulo(alturaRetangulo, larguraRetangulo);
        this.quadrado = new Quadrado(comprimentoLadoQuadrado);
        this.circulo = new Circulo(raioCirculo);
    }

    public static FigurasGeometricas criarFiguras(double altura, double largura, double comprimento, double raio) throws FiguraException{
        FigurasGeometricas fig = new FigurasGeometricas(altura, largura, comprimento, raio);
        return fig;
    }

    public String areaDaFigura(tiposDeFigura tipo) throws FiguraException {
        switch (tipo) {
            case RETANGULO:
                return this.retangulo.calcularArea().toString();

            case QUADRADO:
                return this.quadrado.calcularArea().toString();

            case CIRCULO:
                return this.circulo.calcularArea().toString();

            case TODOS:
                return this.getTodosAreas();

            default:
                throw new FiguraException();
        }
    }

    public String toStringDaFigura(tiposDeFigura tipo) throws FiguraException {
        switch (tipo) {
            case RETANGULO:
                return retangulo.toString();
            case QUADRADO:
                return quadrado.toString();

            case CIRCULO:
                return circulo.toString();

            case TODOS:
                return this.getTodasFiguras();
            default:
                throw new FiguraException();
        }
    }

    public String perimetroDaFigura(tiposDeFigura tipo) throws FiguraException {
        switch (tipo) {
            case RETANGULO:
                return this.retangulo.calcularPerimetro().toString();

            case QUADRADO:
                return this.quadrado.calcularPerimetro().toString();

            case CIRCULO:
                return this.circulo.calcularPerimetro().toString();

            case TODOS:
                return this.getTodosPerimetros();

            default:
                throw new FiguraException();

        }
    }

    public String getTodosAreas() {
        return "Retangulo: " + retangulo.calcularArea() + "\n" +
                "Quadrado: " + quadrado.calcularArea() + "\n" +
                "Circulo: " + circulo.calcularArea() + "\n";

    }

    public String getTodosPerimetros() {
        return "Retangulo: " + retangulo.calcularPerimetro() + "\n" +
                "Quadrado: " + quadrado.calcularPerimetro() + "\n" +
                "Circulo: " + circulo.calcularPerimetro() + "\n";

    }

    public String getTodasFiguras() {
        return retangulo.toString() + "\n" +
                quadrado.toString() + "\n" +
                circulo.toString() + "\n";

    }
}