

'''
This is my project 1 submission.
Alexander Sanna
Professor D. Maini
Due: October 31st, 2023 at 11:59pm
'''

# The following code is part 1 of the entire project (50points) lines 12-150

'''
prints the option menu for the user.
'''
def print_menu():
    print('MENU\nc - Number of non-whitespace characters \nw - Number of words')
    print('f - Fix capitalization\nr - Replace punctuation\ns - Shorten spaces\nq - Quit')

'''
get non whitespce chars takes total chars and subtracts those that are whitespace.
 '''
def get_num_of_non_WS_characters(word):
    count = 0
    for char in word:
        if char == ' ':
            count+=1

    return len(word) - count

'''
get num of words takes the number of chars in the word and subtracts the instances of whitesace.'''
def get_num_of_words(word):
    word = shorten_space(word)
    words = word.split(" ")
    return len(words)

'''
fix capitalization uses flags to edit the word as we traverse it. 
'''
def fix_capitalization(word):
    capFlag = 0
    numFixed = 0
    begin = 1
    arr_char = []
    for char in word:
        if begin == 1:
            if char.isupper() == False:
                char = char.upper()
                numFixed +=1
            arr_char.append(char)
            begin = 0
        elif char == ".":
            capFlag = 1
            arr_char.append(char)
        elif capFlag == 1 and char != " ":
            if char.isupper() == False:
                char = char.upper()
                numFixed +=1
            arr_char.append(char)
            capFlag = 0
        else:
            arr_char.append(char)
    new = ''
    for x in arr_char:
        new+=x
    word = new
    return word, numFixed

'''
replace punctuation uses replace method to edit word.
'''
def replace_punctuation(word):
    exp = 0
    semi = 0
    for char in word:
        if char == '!':
            exp+=1
        elif char == ';':
            semi +=1

    word = word.replace('!','.')
    word = word.replace(';',',')
    return word, semi, exp

'''
shorten space drops the multiple spaces in the string. '''
def shorten_space(word):
    word = word.replace("  ", ' ')
    word = word.replace("   ", ' ')
    word = word.replace("    ", ' ')
    return word


'''
This is the excecute function method specified by the program reqs
'''
def excecute_function(selection, word):
    selection = selection.lower()
    if selection == 'q':
        return word
    elif selection == 'c':
        print("Number of non-whitespaces: ", get_num_of_non_WS_characters(word) )
        return word
    elif selection == 'w':
        print('number of words:', get_num_of_words(word))
        return word
    elif selection == 'f':
        word, numFixed = fix_capitalization(word)
        print("Word Updated, number of edits:", numFixed)
        print("Updated Word: ", word)
        return word
    elif selection == 'r':
        word, numSemi, numExp = replace_punctuation(word)
        print("Punctuation Replaced.\nExclamation count: ", numExp, "\nSemicolon count: ", numSemi)
        return word
    elif selection == 's':
        word = shorten_space(word)
        print("Edited Text: ", word)
        return word
    return word


'''
This is the main method in my part 1.
'''
def mainPart1():
    print("Hello! Welcome to Project 1")
    print("Software engineered by: Alexander J Sanna | forward all questions to ajsanna@cpp.edu")
    print()
    print()

    string_input = str(input("Please enter the desired String: "))
    print()
    print("You've entered: ", string_input)
    validSelections = 'q', 'c', 'w', 'f', 'r', 's'
    userSelection = 'c'
    while userSelection.lower() != 'q':

        if userSelection.lower() != 'q' and userSelection.lower() in validSelections:
            print_menu()
            userSelection = str(input("Please make your selection: "))
            string_input = excecute_function(userSelection, string_input)
        elif userSelection.lower() != 'q':
            userSelection = 'c'
            print("Invalid Entry! Please try again.")

    print("Exit selected, program terminating...\nHave a nice day!")

mainPart1()

#The following code is part 2 of the project: (25pts) lines 155-210
import math


def calculate(circle1, circle2):

    d = ((circle2[0] - circle1[0] ) ** 2 + (circle2[1]-circle1[1])**2)**.5
    if d > circle1[2] + circle2[2]:
        print("No intersect. The circles are separate")
    elif d < abs(circle1[2] - circle2[2]):
        print("the two circles do not intersect, and one is contained within the other.")
    elif  d == circle1[2] + circle2[2]:
        print(" the two circles intersect a single point.")
    elif d  == 0 and circle1[2] == circle2[2]:
        print("the two circles are coincident")
    else:
        print(" the two circles intersect at two points.")


def mainPart2():
    print()
    print()
    print("Part 2")
    strikes = 0
    valid = True
    while strikes < 3:
        inputs = []
        check = []
        x0 = (input("Enter the x0: "))
        check.append(x0)
        y0 = (input("Enter the y0: "))
        check.append(y0)
        r1 = (input("Enter the radius: "))
        inputs.append(r1)
        x1 = (input("Enter the x1: "))
        check.append(x1)
        y1 = (input("Enter the y1: "))
        check.append(y1)
        r2 = (input("Enter the radius: "))
        inputs.append(r2)

        try:
            x0 = float(x0)
            y0 = float(y0)
            y1 = float(y1)
            x1 = float(x1)
            r1 = float(r1)
            r2 = float(r2)
        except:
            valid = False
        if valid is True:
            if r1 < 0 or r2 < 0:
                valid = False

        if valid is True:
            strikes = 0
            circle1 = x0, y0, r1
            circle2 = x1, y1, r2
            calculate(circle1, circle2)

        if valid is False:
            valid = True
            strikes += 1
            if strikes == 3:
                print("Strike 3, get out! ")
            else:
                print("Invalid number, please try again. ")



mainPart2()


#The following is part of Part 3 lines 213-233

print()
print("Part 3")
def mainpart3():
    import random
    runBool = True
    guesses = 1
    target = random.randint(0, 100)
    while runBool:
        guess = int(input("Enter Guess:"))
        if guess > target :
            print('Too big! Try again...')
        elif guess < target:
            print('Too small! Try again...')
        elif guess == target:
            print("You win!! Number guessed in: ", guesses, " guesses.")
            choice = input("play again? y/n")
            if choice.lower() == 'y':
                mainpart3()

            runBool = False
        guesses +=1


mainpart3()

