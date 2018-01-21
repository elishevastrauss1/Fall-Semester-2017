class Dispenser(object, numberOfItems=50, cost=50):
    def __init__(self):
        if numberOfItems<0:
            numberOfItems=50
        if cost<0:
            cost=50
        self.numberOfItems=numberOfItems
        self.cost=cost
    

    def getCount():
        return numberOfItems

    def getProductCost(object):
        return self.cost

    def makeSale():
        numberOfItems--
