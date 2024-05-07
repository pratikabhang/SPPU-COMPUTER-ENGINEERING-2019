from chatterbot import ChatBot
from chatterbot.trainers import ChatterBotCorpusTrainer

chatbot = ChatBot('SitsChatBot')
trainer = ChatterBotCorpusTrainer(chatbot)
trainer.train('chatterbot.corpus.english')

custom_responses = {
    "greetings": ["hi there!", "hello!", "hey!"],
    "how_are_you": ["I'm doing well, thank you!", "I'm fine, thank you for asking."],
    "name": ["My name is SitsChatBot.", "You can call me SitsChatBot."],
    "about": ["I am a chatbot designed to assist you with basic conversations.", "I'm here to help with any questions you have!"],
    "thanks": ["You're welcome!", "No problem.", "Happy to help!"],
    "goodbye": ["Goodbye!", "See you later!", "Bye!"],
    "age": ["I'm just a computer program, so I don't have an age.", "I don't age like humans do."],
    "favorite_color": ["I don't have a favorite color, but I like all colors equally!", "I'm impartial to any color."],
    "hobbies": ["I enjoy chatting with users and helping them!", "My hobby is learning from conversations."]
}


def chat():
    print("Type 'quit' to exit")
    while True:
        user_input = input("You: ").lower()
        if user_input == 'quit':
            break
        elif any(greeting in user_input for greeting in ['hi', 'hello', 'hey']):
            print("Bot:", custom_responses["greetings"][0])
        elif 'how are you' in user_input:
            print("Bot:", custom_responses["how_are_you"][0])
        elif 'what is your name' in user_input:
            print("Bot:", custom_responses["name"][0])
        elif 'tell me about yourself' in user_input:
            print("Bot:", custom_responses["about"][0])
        elif 'thank you' in user_input:
            print("Bot:", custom_responses["thanks"][0])
        elif 'goodbye' in user_input:
            print("Bot:", custom_responses["goodbye"][0])
        elif 'how old are you' in user_input or 'age' in user_input:
            print("Bot:", custom_responses["age"][0])
        elif 'favorite color' in user_input:
            print("Bot:", custom_responses["favorite_color"][0])
        elif 'hobbies' in user_input:
            print("Bot:", custom_responses["hobbies"][0])
        else:
            response = chatbot.get_response(user_input)
            print("Bot:", response)
            
chat()
