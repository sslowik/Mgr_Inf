using System;

namespace Calculator
{
    class Program
    {
        static void Main(string[] args)
        private void btnCalculate_Click(object sender, EventArgs e)
        {
            double result;
            if (!double.TryParse(txtMath.Text, out result))
            {
                MessageBox.Show("Error. Please enter a numeric value!");
                txtMath.Select();
                return;
            }
            if (((Convert.ToDouble(txtMath.Text) > 10))
                || (Convert.ToDouble(txtMath.Text) < 0))
            {
                MessageBox.Show("Error. Please enter from 0 to 10!");
                txtMath.Select();
                return;
            }
            if (!double.TryParse(txtLiteral.Text, out result))
            {
                MessageBox.Show("Error. Please enter a numeric value!");
                txtMath.Select();
                return;
            }
            if (((Convert.ToDouble(txtLiteral.Text) > 10))
                || (Convert.ToDouble(txtMath.Text) < 0))
            {
                MessageBox.Show("Error. Please enter from 0 to 10!");
                txtMath.Select();
                return;
            }
            if (rbtnCountry.Checked)
            {
                txtAverage.Text = txtID.Text + " " + txtName.Text + "  "
                                  + ((Convert.ToDouble(txtMath.Text)
                                      + Convert.ToDouble(txtLiteral.Text) + 1) / 2).ToString();
            }
            else
            {
                txtAverage.Text = txtID.Text + " " + txtName.Text + "  "
                                  + ((Convert.ToDouble(txtMath.Text)
                                      + Convert.ToDouble(txtLiteral.Text)) / 2).ToString();
            }
        }
    }
}
