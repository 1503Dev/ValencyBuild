using System.Text.RegularExpressions;

namespace ValencyBuild.CLI
{
    internal class Program
    {
        static void Main(string[] args)
        {

        }

        static String Parse(String value){
                        // TODO 明天开始写
            // 待替换的字符串
        string input = value;
        
        // 存储变量名和对应值的Dictionary
        Dictionary<string, string> variables = new Dictionary<string, string>
        {
            { "CONST", "value" } 
        };
        
        
        string pattern = @"\$\((\w+)\)";
        

        string result = Regex.Replace(input, pattern, match =>
        {

            string varName = match.Groups[1].Value;

            return variables.TryGetValue(varName, out string value) ? value : match.Value;
        });


        return result;
        }
    }
}
