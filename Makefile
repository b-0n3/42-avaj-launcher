SRC=$(shell find * -name "*.java")
CLASS=$(shell find * -name "*.class")
NAME=com.b0n3.avaj.simulator.Simulator


all: $(NAME)



$(NAME):
	javac $(SRC)


clean:
	rm -rf $(CLASS)


re: fclean all
