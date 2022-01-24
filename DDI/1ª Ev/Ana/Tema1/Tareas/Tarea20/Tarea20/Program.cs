using System;

namespace Tarea20
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("¿Cuántas clases hay?");
            int nClases = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("¿Cuántos alumnos hay por clase?");
            int nAlumnos = Convert.ToInt32(Console.ReadLine());

            decimal[,] calif = new decimal[nClases, nAlumnos];

            Console.WriteLine(calif.GetLength(0));
            Console.Write("A continuación introduzca las notas de los alumnos.");

            for (int i = 0; i < calif.GetLength(0); i++)
            {
                for (int j = 0; j < calif.GetLength(1); j++)
                {
                    Console.Write("\nClase {0}, alumno {1}: ", i + 1, j + 1);
                    calif[i, j] = Convert.ToDecimal(Console.ReadLine());
                }
            }
            decimal max = calif[0, 0];
            decimal min = calif[0, 0];
            decimal mediaTotal = 0;
            for (int i = 0; i < calif.GetLength(0); i++)
            {
                decimal mediaClase = 0;
                for (int j = 0; j < calif.GetLength(1); j++)
                {
                    decimal nota = calif[i, j];
                    mediaClase += nota;
                    mediaTotal += nota;
                    if (max < nota)
                        max = nota;
                    if (min > nota)
                        min = nota;
                }
                Console.Write("\nLa media de la clase {0} es de {1}.", i + 1, mediaClase / calif.GetLength(1));
            }
            Console.Write("\nLa media de todas las clases es de {0}.", mediaTotal / calif.Length);
            Console.Write("\nLa nota más alta es de {0}.", max);
            Console.WriteLine("\nLa nota más baja es de {0}.", min);
        }

    }
}
