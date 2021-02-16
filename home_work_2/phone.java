public class phone 
{
	public static void main(String[] args) // Входные данные
	{
		String str = "89150981795"; // Вводим через присвоение, можно и через консоль, но мы ведь ввод через консоль вроде еще не проходили :)
		number(str);
		System.out.println(number(str)[0]); // Вывод
		System.out.println(number(str)[1]);
		
		/*(str = "+7 915 098 ()17 95"; 
		number(str);
		System.out.println(number(str)[0]);
		System.out.println(number(str)[1]);*/
	}

	public static String[] number(String str) // Главный исполняющий метод
	{
		String[] arr = new String[2]; // На выход отдаем массив из двух строк
		arr[0] = str; // Номер телефона
		arr[1] = ""; // Возможные правки
		ft_del(arr); // Метод для введения правок и записи коментариев о них
		if ((arr[0].length() != 11) || ((arr[0].charAt(0)) == '+')) 
		{
			arr[0] = "Invalid number";
			arr[1] = arr[1] + "The number of characters is more or less than 11;";
		}
		if (arr[1].equals("")) // Если правок не было
		{
			arr[1] = "No changes;";
		}
		return arr;
	}

	public static void ft_del(String[] arr) // Метод удаляет ненужные символы заменой их на пустые строки. Чтобы понять совершили ли мы 
	{										// замену, создаем буферную строку и сравниваем исходную с буферной. Если они отличаются, значит
		String buff; 						// замена прошла и нужно добавить коммент об этом.
		String buff_2; // Буферные строки для сравнения исходного номера и измененного

		buff = arr[0].replace("+7", "8");
		if (!(buff.equals(arr[0])))
		{
			arr[0] = arr[0].replace("+7", "8");
			arr[1] = "Change +7 to 8; ";
		}
		buff = arr[0].replace(" ", "");
		if (!(buff.equals(arr[0])))
		{
			arr[0] = arr[0].replace(" ", "");
			arr[1] = arr[1] + "Spaces in the number; ";
		}
		buff = arr[0].replace(")", "");
		buff_2 = arr[0].replace("(", "");
		if (!((buff.equals(arr[0])) || (buff_2.equals(arr[0]))))
		{
			arr[0] = arr[0].replace(")", "");
			arr[0] = arr[0].replace("(", "");
			arr[1] = arr[1] + "Braces in the number; ";
		}
	}
}
