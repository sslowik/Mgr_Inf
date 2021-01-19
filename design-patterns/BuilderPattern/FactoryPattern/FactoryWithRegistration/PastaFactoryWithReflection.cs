namespace FactoryPattern.FactoryWithRegistration
{
    using System;
    using System.Collections.Generic;
    using FactoryPattern.Model;

    public class PastaFactoryWithReflection : GenericSingleton<PastaFactoryWithReflection>
    {
        private readonly Dictionary<string, Type> registeredTypes;

        private PastaFactoryWithReflection()
        {
            this.registeredTypes = new Dictionary<string, Type>();
        }

        public APasta PreparePasta(string pastaType)
        {
            if (!this.registeredTypes.ContainsKey(pastaType))
            {
                throw new Exception($"Pasta: {pastaType} is not in menu.Sorry!");
            }

            var requestedType = this.registeredTypes[pastaType];
            return (dynamic) Activator.CreateInstance(requestedType);
        }

        public void Register(string pastaType, Type type)
        {
            if (this.registeredTypes.ContainsKey(pastaType))
            {
                throw new Exception($"{pastaType} is already defined.");
            }

            this.registeredTypes[pastaType] = type;
        }
    }
}
