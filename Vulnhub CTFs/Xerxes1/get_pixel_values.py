# Yo (jose pablo peralta) hice este pequeno script para encontrar los valores RBGA de cada pixel en una imagen.# En este caso en especifico, solo me interesan los values Alpha, el cual modifica la opacidad/transparencia
# de cada pixel, ya que en esos valores (decimales), se encuentra un mensaje Base64, cuando se convierten a ASCII.

from PIL import Image

img = Image.open("lostpassword.png", "r")

pix_val = list(img.getdata())

alpha_values = [pix[3] for pix in pix_val]

i = 0

alpha = []

while alpha_values[i] != 255:

    alpha.append(alpha_values[i])
    i += 1

print(alpha)

