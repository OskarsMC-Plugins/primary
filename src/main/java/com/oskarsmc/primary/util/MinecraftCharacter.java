package com.oskarsmc.primary.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.ComponentIteratorType;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * MinecraftCharacter is a utility enum containing common operations for predefined characters, such as
 * <ul>
 *     <li>Getting the width of a particular character.</li>
 *     <li>Getting the width of a particular component.</li>
 *     <li>Getting a message centered to an MOTD.</li>
 *     <li>Getting a message centered to minecraft chat.</li>
 * </ul>
 *
 * @author OskarZyg
 * @since 1.0.0
 */
public enum MinecraftCharacter {
    LETTER_A('A', 5),
    LETTER_a('a', 5),
    LETTER_B('B', 5),
    LETTER_b('b', 5),
    LETTER_C('C', 5),
    LETTER_c('c', 5),
    LETTER_D('D', 5),
    LETTER_d('d', 5),
    LETTER_E('E', 5),
    LETTER_e('e', 5),
    LETTER_F('F', 5),
    LETTER_f('f', 4),
    LETTER_G('G', 5),
    LETTER_g('g', 5),
    LETTER_H('H', 5),
    LETTER_h('h', 5),
    LETTER_I('I', 3),
    LETTER_i('i', 1),
    LETTER_J('J', 5),
    LETTER_j('j', 5),
    LETTER_K('K', 5),
    LETTER_k('k', 4),
    LETTER_L('L', 5),
    LETTER_l('l', 1),
    LETTER_M('M', 5),
    LETTER_m('m', 5),
    LETTER_N('N', 5),
    LETTER_n('n', 5),
    LETTER_O('O', 5),
    LETTER_o('o', 5),
    LETTER_P('P', 5),
    LETTER_p('p', 5),
    LETTER_Q('Q', 5),
    LETTER_q('q', 5),
    LETTER_R('R', 5),
    LETTER_r('r', 5),
    LETTER_S('S', 5),
    LETTER_s('s', 5),
    LETTER_T('T', 5),
    LETTER_t('t', 4),
    LETTER_U('U', 5),
    LETTER_u('u', 5),
    LETTER_V('V', 5),
    LETTER_v('v', 5),
    LETTER_W('W', 5),
    LETTER_w('w', 5),
    LETTER_X('X', 5),
    LETTER_x('x', 5),
    LETTER_Y('Y', 5),
    LETTER_y('y', 5),
    LETTER_Z('Z', 5),
    LETTER_z('z', 5),
    NUMBER_1('1', 5),
    NUMBER_2('2', 5),
    NUMBER_3('3', 5),
    NUMBER_4('4', 5),
    NUMBER_5('5', 5),
    NUMBER_6('6', 5),
    NUMBER_7('7', 5),
    NUMBER_8('8', 5),
    NUMBER_9('9', 5),
    NUMBER_0('0', 5),
    EXCLAMATION_POINT('!', 1),
    AT_SYMBOL('@', 6),
    HASHTAG('#', 5),
    DOLLAR_SIGN('$', 5),
    PERCENT('%', 5),
    UP_ARROW('^', 5),
    AMPERSAND('&', 5),
    ASTERISK('*', 5),
    LEFT_BRACKET('(', 4),
    RIGHT_BRACKET(')', 4),
    MINUS('-', 5),
    UNDERSCORE('_', 5),
    PLUS_SIGN('+', 5),
    EQUALS_SIGN('=', 5),
    LEFT_CURLY_BRACKET('{', 4),
    RIGHT_CURLY_BRACKET('}', 4),
    LEFT_SQUARE_BRACKET('[', 3),
    RIGHT_SQUARE_BRACKET(']', 3),
    COLON(':', 1),
    SEMI_COLON(';', 1),
    DOUBLE_QUOTE('"', 3),
    SINGLE_QUOTE('\'', 1),
    LEFT_ARROW('<', 4),
    RIGHT_ARROW('>', 4),
    QUESTION_MARK('?', 5),
    SLASH('/', 5),
    BACK_SLASH('\\', 5),
    LINE('|', 1),
    TILDE('~', 5),
    TICK('`', 2),
    PERIOD('.', 1),
    COMMA(',', 1),
    SPACE(' ', 3),
    DEFAULT('a', 4);

    /**
     * Constant for the width of an MOTD, in pixels.
     */
    public static final Integer MOTD_PIXEL_SIZE = 154;
    /**
     * Constant for the width of minecraft chat, in pixels.
     */
    public static final Integer CHAT_PIXEL_SIZE = 320;

    private final char minecraftCharacter;
    private final int characterLength;

    /**
     * Creates a MinecraftCharacter instance.
     * @param minecraftCharacter The character to bind to the length.
     * @param characterLength The length (in pixels) of the character.
     */
    MinecraftCharacter(char minecraftCharacter, int characterLength) {
        this.minecraftCharacter = minecraftCharacter;
        this.characterLength = characterLength;
    }

    /**
     * Gets the character bound to the instance.
     * @return The character of the MinecraftCharacter instance.
     */
    @Contract(pure = true)
    public char minecraftCharacter() {
        return minecraftCharacter;
    }

    /**
     * Gets the length of the character.
     * @return The length of the MinecraftCharacter instance, in pixels.
     */
    @Contract(pure = true)
    public int characterLength() {
        return characterLength;
    }

    /**
     * Gets the length of the character if it were bold.
     * @return The length of the MinecraftCharacter instance if it were bold.
     */
    @Contract(pure = true)
    public int boldLength() {
        if (this == MinecraftCharacter.SPACE) return characterLength;
        return this.minecraftCharacter + 1;
    }

    /**
     * Gets the size for a character.
     * @param character The character to get the size for.
     * @param bold Is the character bold?
     * @return The size of the character, in pixels.
     */
    @Contract(pure = true)
    public static @Nullable Integer getSizeForCharacter(char character, Boolean bold) {
        for (MinecraftCharacter minecraftFontSize : MinecraftCharacter.values()) {
            if (minecraftFontSize.minecraftCharacter == character) {
                if (bold) return minecraftFontSize.boldLength();
                return minecraftFontSize.characterLength();
            }
        }
        return null;
    }

    /**
     * Gets the size of a {@link net.kyori.adventure.text.TextComponent}.
     * @param component The component to measure.
     * @return The size of a {@link net.kyori.adventure.text.TextComponent}
     */
    @Contract(pure = true)
    public static Integer getComponentSize(@NotNull TextComponent component) {
        Integer totalSize = 0;

        for (Component componentChild : component.iterable(ComponentIteratorType.DEPTH_FIRST)) {
            if (componentChild instanceof TextComponent child) {
                Boolean bold = child.hasDecoration(TextDecoration.BOLD);
                String text = PlainTextComponentSerializer.plainText().serialize(child);
                for (char currentCharacter : text.toCharArray()) {
                    totalSize += MinecraftCharacter.getSizeForCharacter(currentCharacter, bold);
                }
            }
        }
        return totalSize;
    }

    /**
     * Get a {@link net.kyori.adventure.text.TextComponent} centered for an MOTD.
     * @param component The {@link net.kyori.adventure.text.TextComponent} to center.
     * @return The {@link net.kyori.adventure.text.TextComponent} centered for an MOTD.
     */
    @Contract(pure = true)
    public static @NotNull TextComponent getMOTDCenteredMessage(@NotNull TextComponent component) {
        return getCenteredMessage(component, MOTD_PIXEL_SIZE);
    }

    /**
     * Get a {@link net.kyori.adventure.text.TextComponent} centered for minecraft chat.
     * @param component The {@link net.kyori.adventure.text.TextComponent} to center.
     * @return The {@link net.kyori.adventure.text.TextComponent} centered for minecraft chat.
     */
    @Contract(pure = true)
    public static @NotNull TextComponent getChatCenteredMessage(@NotNull TextComponent component) {
        return getCenteredMessage(component, CHAT_PIXEL_SIZE);
    }

    /**
     * Get a {@link net.kyori.adventure.text.TextComponent} centered for a certain width.
     * @param component The {@link net.kyori.adventure.text.TextComponent} to center.
     * @param lengthToCompensateFor The width to center the {@link net.kyori.adventure.text.TextComponent} for, in pixels.
     * @return The centered {@link net.kyori.adventure.text.TextComponent}.
     */
    private static @NotNull TextComponent getCenteredMessage(@NotNull TextComponent component, @NotNull Integer lengthToCompensateFor) {
        Integer messageSize = MinecraftCharacter.getComponentSize(component);
        int messageSizeHalved = messageSize / 2;
        int spaceLength = MinecraftCharacter.SPACE.characterLength() + 1;
        int compensated = 0;

        ComponentBuilder<TextComponent, TextComponent.Builder> componentBuilder = Component.text();
        while (compensated < lengthToCompensateFor - messageSizeHalved) {
            compensated += spaceLength;
        }
        componentBuilder.append(Component.text(" ".repeat(compensated / spaceLength)));

        return componentBuilder.append(component).build();
    }
}
