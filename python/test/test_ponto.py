from pytest import approx

try:
    # funciona no Pycharm
    from ..geometria.ponto import Ponto
except ImportError:
    # funciona pela linha de comando
    from geometria.ponto import Ponto


# pytest prefere 'test' à 'teste'
def test_distancia_euclidiana():
    p1 = Ponto(0, 0)
    p2 = Ponto(3, 4)

    correta = ((p2.x - p1.x) ** 2 + (p2.y - p1.y) ** 2) ** (1. / 2.)

    assert p1.distancia_euclidiana(p2) == approx(correta, rel=1e-2)
