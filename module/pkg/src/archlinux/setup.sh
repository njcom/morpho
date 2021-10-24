#!/usr/bin/env bash

# todo: https://wiki.archlinux.org/title/Archinstall
# Based on [How to install Arch Linux with Encryption on an MBR system](https://www.youtube.com/watch?v=Wssy2tz2k90)

set -eu

readonly legacyBiosPkgs="grub"
readonly uefiBiosPkgs="efibootmgr"
readonly lvmPkgs="lvm2"
readonly kernelPkgs="mkinitcpio linux-lts linux-firmware linux-lts-headers"
readonly basePkgs="archlinux-keyring nftables vim tmux man-pages man-db texinfo mc lessi curl wget sudo"
readonly desktopPkgs="netctl dialog wpa_supplicant openresolv dhcpcd gdisk xorg-server xorg-xinit xf86-video-intel plasma-desktop sddm konsole fish"
readonly serverPkgs="openssh"
readonly devPkgs="base-devel docker git jq"
readonly rePkgs="atop htop hdparm dstat ethtool perf iotop lsof nmap openbsd-netcat procps-ng net-tools iproute2 iputils strace"

readonly hostname=lap
readonly user=john-doe

# todo: ask interactively
readonly devPath=/dev/sda
if isLegacyBios; then
    readonly biosBootPartition=${devPath}1
    readonly efiSystemPartion=${devPath}2
    readonly rootPartition=${devPath}3
else
    readonly efiSystemPartion=${devPath}1
    readonly rootPartiton=${devPath}2
fi
readonly mountDirPath=/mnt

downloadLatestImage() {
    :
}

# Wipes disk not securely
wipeDisk() {
    set +e
    wipefs --all --force
    partprobe
    set -e
}

# Creates a partition table, using MBR layout or GPT layout.
partitionDisk() {
    # Useful codes:
    #     ef00 EFI System
    #     ef02 BIOS boot partition
    #     8e00 Linux LVM
    #     8300 Linux filesystem
    #     8200 Linux swap
    #     LBA == 1 sector == 512 bytes, starts from 0
    if isLegacyBios; then
        echo todo
        # BIOS boot partition:
        # size: 2MB
        # type: ef02
    fi
        (
            echo o       # Create new partition table
            echo Y       # Confirm

            # Create EFI partition
            echo n       # Create first partition
            echo         # Accept default partition number
            echo         # Accept default first sector
            echo "+500M" # Partition size
            echo ef00    # Partition type is ESP/EFI System Partition

            # Create ext4 partition
            echo n       # Create second partition
            echo         # Accept default partition number
            echo         # Accept default first sector
            echo         # Accept default last sector (all free space)
            echo         # Accept default partition type 8300 (Linux filesystem)
            #createLvmPartition

            echo w       # Write GPT table to disk and exit
            echo Y       # Confirm
        ) | gdisk "$1"
    partprobe || true
}

formatPartitions() {
    mkfs.fat -F32 "$efiSystemPartition"
    mkfs.ext4 "$rootPartition"
}

mountPartitions() {
    mount --verbose "$rootPartition" "$mountDirPath"

    mkdir -p "$mountDirPath"/boot
    mount --verbose "$efiSystemPartition" "$mountDirPath"/boot
}

setupBase() {
    pacstrap "$mountDirPath"

    # Date and time
    ln -sfrn /usr/share/zoneinfo/UTC /etc/localtime
    timedatectl set-ntp true
    hwclock --systohc

    # Locale
    # NB: perl can't be used due not configured locale
    sed -i -E 's/#(en_US\.UTF-8\s+UTF-8)/\1/' /etc/locale.gen
    locale-gen
    echo 'LANG=en_US.UTF-8' > /etc/locale.conf

    echo -e "127.0.0.1\tlocalhost\n::1\tlocalhost\n" > /etc/hosts
    echo "$hostname" > /etc/hostname

    genfstab -U "$mountDirPath" > "$mountDirPath"/etc/fstab

    # initramfs
    sed -i -E 's/^HOOKS=.*/HOOKS=(base udev autodetect modconf block lvm2 filesystems keyboard fsck)/' /etc/mkinitcpio.conf
    mkinitcpio -P
    
    # Change root's password
    passwd

    useradd -G wheel -m -s /bin/bash $user
    passwd $user
    echo -e "Defaults:%wheel targetpw\n%wheel ALL=(ALL) ALL\n" >> /etc/sudoers
}

setupBootloader() {
    if isLegacyBios; then
        setupGrub
    else
        setupEfiStub
    fi
}

setupEfiStub() {
    :
}

setupGrub() {
    # todo: kernel parameters:
    # sed -i GRUB_CMDLINE_LINUX=... /etc/default/grub
    grub-install --target=i386-pc "$devPath"
    grub-mkconfig -o /boot/grub/grub.cfg
}

setupDesktop() {
    sudo systemctl enable --now sddm
}

main() {
    :
}
