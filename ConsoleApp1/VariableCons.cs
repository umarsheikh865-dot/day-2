using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;
using System.Threading.Tasks;
using System.Reflection.Metadata;

namespace ConsoleApp1
{
    internal class VariableCons
    {
        const int Y = 200;
        static int x = 100; //global variable

        public static void Fun()
        {
            //int x = 10;
            //x = 20;
            //x = 30;
            //Console.WriteLine("x=" + x);
            //Console.WriteLine("Y=" + Y);

            int x = 100;
            float y = 2.345F;
            string s = "hello";
            double d = 422222222.456;
            bool bl = true;
            Console.WriteLine($"x={x} y={y} s = {s} bl = {bl} d= {d}");

            Int16 x1 = 122;
            Int64 x2 = 1222222222;
            Double dl = 4555555.23;
            Boolean bl2 = true;
            Console.WriteLine($"x1={x1} x2={x2} dl = {dl} bl = {bl2} d= {bl2}");

            object obj = null; // Corrected: Declared and assigned the object
        }
    }
} // Corrected: Balanced closing braces