# Reset keys
setxkbmap -option
setxkbmap

# Load keys
xkbcomp ~/.config/xkb/my "$DISPLAY"
