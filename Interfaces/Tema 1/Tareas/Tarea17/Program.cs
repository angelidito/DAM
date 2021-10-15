using System;

namespace Tarea17
{
    class Program
    {
        public static Boolean IsPrime(int n)
        {
            if (n < 2)
                return false;
            if (n == 2)
                return true;
            if (n % 2 == 0)
                return false;
            for (int i = 3; i < n / 2; i += 2)
                if (n % i == 0)
                    return false;
            return true;
        }

        static void Main(string[] args)
        {
            Console.Write("2");
            for (int i = 3; i < 101; i+=2)
                if (IsPrime(i))
                    Console.Write(", {0}", i);
        }

    }
}
