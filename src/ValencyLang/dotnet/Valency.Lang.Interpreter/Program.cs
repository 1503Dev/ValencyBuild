using System.Text;

namespace Valency.Lang.Interpreter
{
    internal class Program
    {
        static void Main(string[] args)
        {
            FileInfo source = new FileInfo("test.vl");

            int lineNum = 1;
            int charOfLineNum = 1;
            int current = 0;
            var content = File.ReadAllText(source.FullName,System.Text.Encoding.UTF8);
            while (true)
            {
                if ((content[current]=='\t')|| (content[current] == ' '))
                {
                    current++;
                    charOfLineNum++;
                    continue;
                }
                if (content[current] == '\n')
                {
                    lineNum++;
                    charOfLineNum = 0;
                    current++;
                    continue;
                }

                StringBuilder keyword = new(128);
                while (true)
                {

                    if (content[current+1]==' ')
                    {
                        break;
                    }
                    keyword.Append(content[current]);
                }

                switch (Keyword.GetKeyword(keyword.ToString()))
                {
                    case Keyword.KeywordType.Const:
                        while (true)
                        {

                        }
                        break;
                    case Keyword.KeywordType.Function:
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
