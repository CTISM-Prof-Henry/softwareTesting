class Ponto {
    constructor (x, y) {
        this.x = x;
        this.y = y;
    }

    distancia_euclidiana(outro) {
        return Math.sqrt(
            Math.pow(this.x - outro.x, 2) +
            Math.pow(this.y - outro.y, 2)
        )
    }
}

module.exports = Ponto;
