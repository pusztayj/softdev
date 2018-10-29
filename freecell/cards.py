"""
Author: Justin Pusztay
File: cards.py
Project 9

Module for playing cards, with classes Card and Deck
""" 
import random
class Card(object):
    """ A card object with a suit, rank, and file name.
    The file name refers to the card's image on disk."""

    RANKS = tuple(range(1, 14))

    SUITS = ('Spades', 'Hearts', 'Diamonds', 'Clubs')

    BACK_NAME = 'DECK/b.gif'

    def __init__(self, rank, suit):
        """Creates a card with the given rank and suit."""
        if not (rank in Card.RANKS):
            raise RuntimeError('Rank must be in ' + str(Card.RANKS))
        if not (suit in Card.SUITS):
            raise RuntimeError('Suit must be in ' + str(Card.SUITS))
        self.rank = rank
        self.suit = suit
        self.fileName = 'DECK/' + str(rank) + suit[0].lower() + '.gif'
        
    def __str__(self):
        """Returns the string representation of a card."""
        if self.rank == 1:
            rank = 'Ace'
        elif self.rank == 11:
            rank = 'Jack'
        elif self.rank == 12:
            rank = 'Queen'
        elif self.rank == 13:
            rank = 'King'
        else:
            rank = self.rank
        return str(rank) + ' of ' + self.suit

    def getFileName(self):
        return self.fileName

## class Deck goes here
class Deck(object):
    """A deck object that starts with 52 cards."""
    def __init__(self):
        self.deck = []
        for suit in Card.SUITS:
            for rank in Card.RANKS:
                self.deck.append(Card(rank,suit))
        #print(self.deck)

    def __str__(self):
        """Returns the string representation of a card."""
        deck = [str(item) for item in self.deck]
        return str(deck)

##    def __iter__(self):
##        cursor = 0 
##        while cursor < len(self.deck):
##            yield self.deck[cursor]
##            ##if temp != self._modCount:
##                #raise AttributeError("Illegal modification of the backing store.")
##            cursor += 1
##        

    def __len__(self):
        """Returns the length of a list."""
        return len(self.deck)

    def isEmpty(self):
        """Checks if the deck is empty."""
        if len(self.deck) == 0:
            return True
        else:
            return False

    def shuffle(self):
        """Shuffles the deck."""
        random.shuffle(self.deck)
        #print("The shuffled deck: ", self.deck)


    def deal(self):
        
        chosen_card = self.deck[0]
        #print("The chosen card from deck: ",chosen_card)
        self.deck.remove(chosen_card)
        #print("\nRemaining Cards in Initial Deck:")
        #print(self.deck)
        
        return chosen_card
