const Ponto = require("../src/ponto");

QUnit.module("Ponto", () => {

    QUnit.test("distancia_euclidiana calcula corretamente", (assert) => {
        const p1 = new Ponto(0, 0);
        const p2 = new Ponto(3, 4);

        const correta = Math.sqrt(
            Math.pow(p1.x - p2.x, 2) +
            Math.pow(p1.y - p2.y, 2)
        );
        assert.equal(p1.distancia_euclidiana(p2), correta);
    });
});