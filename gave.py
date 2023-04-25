import random

# Define a list of possible gift-givers and hints about them
gift_givers = [
    {"name": "your mom", "hint": "She's known for her excellent cooking skills."},
    {"name": "your dad", "hint": "He's always been interested in your hobbies."},
    {"name": "your best friend", "hint": "You've known each other since elementary school."},
    {"name": "your partner", "hint": "You both love to travel together."},
    {"name": "your boss", "hint": "They always appreciate your hard work."},
]

# Define a function to prompt the user for their guess
def get_guess():
    guess = input("Who do you think gave you this present? ")
    return guess

# Define a function to display a hint to the user
def display_hint(gift_giver):
    print(f"Here's a hint: {gift_giver['hint']}")

# Define the main function for the game
def main():
    print("You wake up to find a small box with a note on it that reads:")
    print("'I hope you like this, it's something special that I've been saving for you.'")
    print("You open the box to find a beautiful piece of jewelry.")
    print("You start to wonder who could have given you this gift.")
    gift_giver = random.choice(gift_givers)

    num_guesses = 0
    max_guesses = 3
    guessed_correctly = False

    while num_guesses < max_guesses:
        guess = get_guess()
        num_guesses += 1

        if guess.lower() == gift_giver["name"]:
            print(f"You guessed right! {gift_giver['name']} gave you the gift.")
            guessed_correctly = True
            break
        else:
            print("Sorry, that's not correct.")
            if num_guesses < max_guesses:
                display_hint(gift_giver)

    if not guessed_correctly:
        print(f"Sorry, you've run out of guesses. {gift_giver['name']} gave you the gift.")

# Call the main function
main()
