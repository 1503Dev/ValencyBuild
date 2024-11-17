using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ValencyPrompt
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var ModuleName = "VShell";
            var ProjectName = "null";
            var CurrentDirectory = new FileInfo(".");
            var promptColor = ConsoleColor.Green;

            while (true)
            {
                
                Console.ForegroundColor = promptColor;
                Console.Write($"\n┌─[");
                Console.ResetColor();
                Console.Write($"{ModuleName}");
                Console.ForegroundColor = promptColor;
                Console.Write($"]─(");
                Console.ResetColor();
                Console.Write($"{ProjectName}");
                Console.ForegroundColor = promptColor;
                Console.Write($")-[");
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.Write($"{CurrentDirectory.FullName}");
                Console.ForegroundColor = promptColor;
                Console.Write($"]\n└─");
                Console.ForegroundColor = ConsoleColor.Blue;
                Console.Write($"$ ");
                Console.ResetColor();
                
                
                var command = Console.ReadLine();
                if (command == "")
                {
                    continue;
                }
                switch (command.ToLower())
                {
                    case "help":
                        displayHelp();
                        break;
                    case " ":
                        break;
                    default:
                        Console.WriteLine($"'{command}'：不是可用的命令或是外部文件。");
                        break;
                }
            }
        }

        private static void displayHelp()
        {
            Console.ResetColor();
            Console.WriteLine("可用帮助：");
            Console.WriteLine("\n{0,-15} {1,-15}","名称","描述");
            Console.WriteLine("--------------------------------------------");
            Console.WriteLine("{0,-15} {1,-15}", "help", "获取VShell的帮助。");

        }
    }
}
