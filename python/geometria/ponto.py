class Ponto(object):
    def __init__(self, x: float, y: float):
        self._x = x
        self._y = y

    @property
    def x(self):
        return self._x

    @property
    def y(self):
        return self._y

    def distancia_euclidiana(self, outro) -> float:
        return (
                (self.x - outro.x) ** 2 +
                (self.y - outro.y) ** 2
        ) ** (1. / 2.)