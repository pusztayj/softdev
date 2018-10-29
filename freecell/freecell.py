"""
In this file we will create a freecell class.
"""

from cards import Deck
from linkedstack import LinkedStack


############################################################
### When translating to Java drop the x off of tableaux. ###
###               Please write tableau!                  ###  
############################################################

class FreeCell(object):

    def __init__(self):
        self.deck = Deck()
        self.deck.shuffle()
        
        self.tableaux1 = LinkedStack()
        self.tableaux2 = LinkedStack()
        self.tableaux3 = LinkedStack()
        self.tableaux4 = LinkedStack()
        self.tableaux5 = LinkedStack()
        self.tableaux6 = LinkedStack()
        self.tableaux7 = LinkedStack()
        self.tableaux8 = LinkedStack()

        self.freecell1 = list()
        self.freecell2 = list()
        self.freecell3 = list()
        self.freecell4 = list()

        self.foundation1 = LinkedStack()
        self.foundation2 = LinkedStack()
        self.foundation3 = LinkedStack()
        self.foundation4 = LinkedStack()

        self.sendToTableaux()
        
    def sendToTableaux(self):
        """
        Allocates the cards to correct tableaux piles. With 4 piles of 7
        and 4 piles of 6.
        """
        count = 0
        deck = list(self.deck.deck)
        cards1 = deck[0:7]
        cards2 = deck[7:14]
        cards3 = deck[14:21]
        cards4 = deck[21:28]
##        for a in cards1:
##            self.tableaux1.push(a)
##        for b in cards2:
##            self.tableaux2.push(b)
##        for c in cards3
        for a,b,c,d in zip(cards1,cards2,cards3,cards4):
            self.tableaux1.push(a)
            self.tableaux2.push(b)
            self.tableaux3.push(c)
            self.tableaux4.push(d)
        cards5 = deck[28:34]
        cards6 = deck[34:40]
        cards7 = deck[40:46]
        cards8 = deck[46:52]
        for a,b,c,d in zip(cards5,cards6,cards7,cards8):
            self.tableaux5.push(a)
            self.tableaux6.push(b)
            self.tableaux7.push(c)
            self.tableaux8.push(d)

    def __str__(self):
        pass

    def movetoFreeCell(self,card,freecell):
        pass

    def movetoFoundation(self,card,foundation):
        pass

    def movetoTableaux(self,card,tableaux):
        pass

    def winner(self):
        pass

    

a = FreeCell()
a.sendToTableaux()
            
            

        



