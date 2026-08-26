package a19_08_26;

import java.util.Scanner;

public class tp1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean login = false;
		int indicecuent = -1;// para mostrar en que lugar esta la cuenta el pin,saldo y la cuenta

		int Maxretiro = 2000;// el maximo que una cuenta puede retirar
		int Minretiro = 100;

		int retiro = 0;// para cuando retiras plata

		int[] Cuentas = { 101, 102, 103, 104, 105 };

		double[] Pin = { 1001, 2002, 3003, 4004, 5005 };

		int[] Saldo = { 500, 500, 500, 500, 100 };// la plata prestablecida por cada usuario

		String[] nombres = { "Pedro", "Juan", "Espartano", "Felipe", "Manuela" };// dependiendo de la cuenta sale el
		// nombre

		for (int val = 0; val <= 3 && !login; val++) {

			System.out.print("Introduzca su numero de cuenta:");// pide el numero de la cuenta para ingresar
			int cue = sc.nextInt();// pide el numero de cuenta

			System.out.println("Ingrese el pin de la cuenta:");// ahora pide la contraseña
			int contra = sc.nextInt();// pide la contraseña al usuario

			for (int i = 0; i < Cuentas.length; i++) {
				if (Cuentas[i] == cue) {
					indicecuent = i;
					break;
				}
			}

			if (indicecuent == -1) {
				System.out.println("Error vuelva a ingresar el ID");
				System.out.println("");

			} else if (Pin[indicecuent] != contra) {
				System.out.println("Error vuelva a ingresar la contraseña");
				System.out.println("");
			} else {
				login = true;
				System.out.println("");
				System.out.println("Bienvenido/a " + nombres[indicecuent]);
				System.out.println("");
				int opciones = 0;
				while (opciones != 6) {
					System.out.println("1 Consultar saldo");
					System.out.println("2 Depositar");
					System.out.println("3 Retirar");
					System.out.println("4 Trasnferir a otra cuenta");
					System.out.println("5 Salir");
					opciones = sc.nextInt();

					switch (opciones) {

					case 1:// consultar saldo
						System.out.println("Su saldo es: " + Saldo[indicecuent]);
						System.out.println("");

						break;

					case 2:// deposito de plataza
						System.out.print("Ingrese el monto a depositar");
						int deposito = sc.nextInt();
						if (deposito > 0) {
							Saldo[indicecuent] += deposito;
							System.out.println("");
							System.out.println("Su saldo es: " + Saldo[indicecuent]);
							System.out.println("");
						} else {
							System.out
									.println("Diga un numero mayor a 0 o de otra forma no se podra hacer el deposito");

						}
						break;

					case 3:// retirar plata
						System.out
								.print("Ingrese el monto a retirar en un valor entre " + Minretiro + " y " + Maxretiro);
						System.out.println("");
						retiro = sc.nextInt();
						if (retiro >= Minretiro && retiro <= Maxretiro) {
							if (retiro <= Saldo[indicecuent]) {// por si el retiro es mayor a el saldo de una cuenta
																// no
																// deja retirar
								Saldo[indicecuent] -= retiro;
								System.out.println("Su nuevo saldo es: " + Saldo[indicecuent]);
								System.out.println("");
							} else {
								System.out.println("No cuentas con el dinero suficiente");
								System.out.println("");
							}
						} else {
							System.out.println("Error vuelva a introducir el monto ");
							System.out.println("");
						}
						break;

					case 4:// trans a otra cuenta
						boolean cuentaEncontrada = false;
						System.out.println("Diga el monto a transferir");

						int trans = sc.nextInt();// dice el monto que queres transferir
						if (trans >= Minretiro && trans <= Maxretiro && trans <= Saldo[indicecuent]) {// por si el monto
																										// es mayor
							System.out.println("Diga el numero de cuenta al que quiere tranferir");
						} else {
							System.out.println("Introduzca bien el monto que quiere transferir ");
							System.out.println("");
							break;
						}
						int cuentrans = sc.nextInt();// es la cuenta a la que vas a tranferir

						for (int t = 0; t < Cuentas.length; t++) {

							if (Cuentas[t] == cuentrans) {
								cuentaEncontrada = true;

								Saldo[t] += trans;// cuanta a las que tranferis

								Saldo[indicecuent] -= trans;// cuenta que transfiere se le resta la plata
								System.out.println("el saldo final es de: " + Saldo[indicecuent]);
								System.out.println("");
								break;
							} else if (cuentaEncontrada = false) {
								System.out.println("Introduzca bien el numero de cuenta");
								System.out.println("");
							}
						}
						break;
					case 5:// salir
						System.out.println("Saliendo de su cuenta...");
						System.out.println("");
						System.out.println("			------Resumen de sesion------");
						System.out.println("Titular: " + nombres[indicecuent] + " " + "ID: " + Cuentas[indicecuent]);
						System.out.println("Saldo: " + Saldo[indicecuent]);
						System.out.println("Muchas gracias por elegirnos, hasta pronto!");
						login = false;
						break;
					}
				}
			}
		}
		sc.close();
	}
}
