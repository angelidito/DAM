using System;

namespace Tarea19
{
    class Program
    {
        static void Main(string[] args)
        {
            int op;

            do
            {
                Console.WriteLine("Calculador de areas:\n" +
                    "\t1. Circulo\n" +
                    "\t2. Cuadrado\n" +
                    "\t3. Triangulo\n" +
                    "\t0. Salir");
                op = Convert.ToInt32(Console.ReadLine());

                double area = -1;
                switch (op)
                {
                    case 1:
                        area = CalcAreaCi();
                        break;
                    case 2:
                        area = CalcAreaCu();
                        break;
                    case 3:
                        area = CalcAreaT();
                        break;
                    default:
                        Console.WriteLine("Eliga una de las opciones disponibles, por favor.");
                        break;
                }

                if (area != -1)
                    Console.WriteLine("El area es de {0} ud cuadradas. \n\n", area);

            } while (op != 0);
        }

        private static double CalcAreaCi()
        {
            Console.WriteLine("¿Cuál es el radio del círculo?");

            double radio = Convert.ToDouble(Console.ReadLine());

            return radio * Math.PI * Math.PI;
        }
        private static double CalcAreaCu()
        {
            Console.WriteLine("¿Cuál es el lado del cuadrado?");

            double lado = Convert.ToDouble(Console.ReadLine());

            return lado * lado;
        }

        private static double CalcAreaT()
        {
            Console.WriteLine("¿Cuál es el altura del triángulo");

            double altura = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("¿Cuál es el alto del triángulo");

            double base_ = Convert.ToDouble(Console.ReadLine());

            return base_ * altura / 2;
        }
    }
}
