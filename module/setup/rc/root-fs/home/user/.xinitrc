# Reset keys
setxkbmap -option
setxkbmap

# Load keys
xkbcomp ~/.config/morpho/xkb "$DISPLAY"
